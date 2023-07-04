package DesignPatterns.snakeandladders;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    private Board board;
    private Deque<Player> players;
    private Dice dice;

    public Game() {
        board = new Board();
        players = new LinkedList<>();
        dice = new Dice();
        addTwoPlayers();
    }

    public Game(Board board, Deque<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    private void addTwoPlayers() {
        players.add(new Player("Kishan", 0));
        players.add(new Player("Vishal", 0));
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Deque<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Deque<Player> players) {
        this.players = players;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void startGame() {
        while (true) {
            Player player = players.removeFirst();
            System.out.println("Player " + player.getName() + " is rolling the dice!");
            int diceResult = dice.rollDice();
            System.out.println("Dice result: " + diceResult);
            int playerNewPosition = player.getCurrentPosition() + diceResult;
            playerNewPosition = checkPositionAfterJump(playerNewPosition);
            player.setCurrentPosition(playerNewPosition);
            System.out.println("Player " + player.getName() + " is now in position " + playerNewPosition);
            if (playerNewPosition > getBoard().getSize() * getBoard().getSize() - 1) {
                System.out.println("Player " + player.getName() + " has won");
                return;
            }
            players.addLast(player);
        }

    }

    private int checkPositionAfterJump(int playerNewPosition) {
        if (playerNewPosition > getBoard().getSize() * getBoard().getSize() - 1) {
            return playerNewPosition;
        }
        Board board = getBoard();
        Cell cell = board.getCell(playerNewPosition);
        if (cell.getJump() != null) {
            Jump jump = cell.getJump();
            if (jump.getStart() > jump.getEnd()) {
                System.out.println("Found a snake! :(");
            } else if (jump.getEnd() > jump.getStart()) {
                System.out.println("Yay! found a ladder :)");
            }
            playerNewPosition = jump.getEnd();
        }
        return playerNewPosition;
    }
}
