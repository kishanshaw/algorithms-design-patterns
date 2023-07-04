package DesignPatterns.snakeandladders;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private Cell[][] cells;
    private int size;
    private int noOfSnakes;
    private int noOfLadders;

    public Board() {
        size = 10;
        cells = new Cell[size][size];
        noOfSnakes = 5;
        noOfLadders = 5;
        initialiseBoard();
    }

    public Board(Cell[][] cells, int size, int noOfSnakes, int noOfLadders) {
        this.cells = cells;
        this.size = size;
        this.noOfLadders = noOfLadders;
        this.noOfSnakes = noOfSnakes;
    }

    public int getNoOfSnakes() {
        return noOfSnakes;
    }

    public void setNoOfSnakes(int noOfSnakes) {
        this.noOfSnakes = noOfSnakes;
    }

    public int getNoOfLadders() {
        return noOfLadders;
    }

    public void setNoOfLadders(int noOfLadders) {
        this.noOfLadders = noOfLadders;
    }

    private void initialiseBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cells[row][col] = new Cell();
            }
        }

        //Create snakes and ladders
        int snakesCount = getNoOfSnakes();
        int laddersCount = getNoOfLadders();
        while (snakesCount > 0) {
            int snakeStart = ThreadLocalRandom.current().nextInt(1, size * size - 1);
            int snakeEnd = ThreadLocalRandom.current().nextInt(1, size * size - 1);
            if (snakeEnd >= snakeStart) {
                continue;
            }
            Cell cell = getCell(snakeStart);
            cell.setJump(new Jump(snakeStart, snakeEnd));
            snakesCount--;
        }
        while (laddersCount > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, size * size - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, size * size - 1);
            if (ladderEnd <= ladderStart) {
                continue;
            }
            Cell cell = getCell(ladderStart);
            cell.setJump(new Jump(ladderStart, ladderEnd));
            laddersCount--;
        }
    }

    public Cell getCell(int position) {
        int boardRow = position / size;
        int boardCol = position % size;
        return cells[boardRow][boardCol];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
