package DesignPatterns.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    private Deque<Player> players;
    private Board gameBoard;

    public TicTacToeGame() {
        players = new LinkedList<>();
        gameBoard = new Board();
        players.add(new Player("Kishan", new PlayingPieceX()));
        players.add(new Player("Vishal", new PlayingPieceO()));
    }

    public TicTacToeGame(Deque<Player> players, Board gameBoard) {
        this.players = players;
        this.gameBoard = gameBoard;
    }

    public Deque<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Deque<Player> players) {
        this.players = players;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String startGame() {
        boolean isWinnerDecided;
        PlayingPiece[][] board = gameBoard.getBoard();
        int totalMoves = board.length * board.length;
        int move = 0;
        while (true) {
            printBoard(gameBoard);
            Player player = players.removeFirst();
            move++;
            System.out.print("\nEnter your move, player " + player.getName() + " as row and column: ");
            Scanner scanner = new Scanner(System.in);
            String[] inputs = scanner.nextLine().split(",");
            int row = Integer.parseInt(inputs[0]);
            int col = Integer.parseInt(inputs[1]);
            if (board[row][col] != null) {
                System.out.println("Invalid input! Try again");
                players.addFirst(player);
                continue;
            }
            board[row][col] = player.getPlayingPiece();
            isWinnerDecided = haveWeFoundWinner(board, player.getPlayingPiece(), row, col);
            if (isWinnerDecided) {
                return "Winner is " + player.getName();
            }
            players.addLast(player);
            if (move == totalMoves) {
                return "It's a tie";
            }
        }
    }

    private boolean haveWeFoundWinner(PlayingPiece[][] board, PlayingPiece playingPiece, int row, int col) {
        PieceType pieceType = playingPiece.getPieceType();
        int size = board.length;
        boolean isRowMatch = true, isColumnMatch = true, isDiagonalMatch = true, isAntiDiagonalMatch = true;

        //check across the row
        for (int i = 0; i < size; i++) {
            if (board[row][i] == null || board[row][i].getPieceType() != pieceType) {
                isRowMatch = false;
                break;
            }
        }

        //Check across column
        for (int i = 0; i < size; i++) {
            if (board[i][col] == null || board[i][col].getPieceType() != pieceType) {
                isColumnMatch = false;
                break;
            }
        }

        //Check across diagonal
        for (int i = 0, j = 0; i < size && j < size; i++, j++) {
            if (board[i][j] == null || board[i][j].getPieceType() != pieceType) {
                isDiagonalMatch = false;
                break;
            }
        }

        //Check across anti-diagonals
        for (int i = 0, j = size - 1; i >= 0 && j >= 0; i++, j--) {
            if (board[i][j] == null || board[i][j].getPieceType() != pieceType) {
                isAntiDiagonalMatch = false;
                break;
            }
        }
        return isRowMatch || isColumnMatch || isDiagonalMatch || isAntiDiagonalMatch;
    }

    public void printBoard(Board gameBoard) {
        int m, n;
        m = n = gameBoard.getSize();
        int i, j;
        PlayingPiece[][] board = gameBoard.getBoard();
        for (i = 0; i < m; i++) {
            StringBuilder builder = new StringBuilder();
            for (j = 0; j < n; j++) {
                builder.append(" | ");
                if (board[i][j] != null) {
                    builder.append(board[i][j].getPieceType().name());
                }
            }
            if (j == n) {
                builder.append(" |");
            }
            System.out.print(builder);
            System.out.println();
        }
    }
}
