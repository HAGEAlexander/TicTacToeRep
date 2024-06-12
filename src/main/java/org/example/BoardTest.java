package org.example;

public class Board {
    private String[] board;

    public Board(String[] board) {
        this.board = board;
    }

    public String[] getBoard() {
        return board;
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("|---|---|---|\n");
        sb.append("| " + board[0] + " | " + board[1] + " | " + board[2] + " |\n");
        sb.append("|-----------|\n");
        sb.append("| " + board[3] + " | " + board[4] + " | " + board[5] + " |\n");
        sb.append("|-----------|\n");
        sb.append("| " + board[6] + " | " + board[7] + " | " + board[8] + " |\n");
        sb.append("|---|---|---|\n");
        return sb.toString();
    }
}
