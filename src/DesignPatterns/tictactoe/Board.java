package DesignPatterns.tictactoe;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board() {
        this.size = 3;
        board = new PlayingPiece[size][size];
    }

    public Board(int size, PlayingPiece[][] board) {
        this.size = size;
        this.board = board;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public void setBoard(PlayingPiece[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
