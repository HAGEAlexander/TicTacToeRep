package org.example;

public class TicTacToe {
    private String[] board;
    private String turn;

    public TicTacToe() {
        board = new String[9];
        turn = "X";
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
    }

    public boolean play(int numInput) {
        if (board[numInput - 1].equals(String.valueOf(numInput))) {
            board[numInput - 1] = turn;
            turn = turn.equals("X") ? "O" : "X";
            return true;
        }
        return false;
    }

    public String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (board[a].equals(String.valueOf(a + 1))) {
                return null;
            }
        }

        return "draw";
    }

    public String getTurn() {
        return turn;
    }

    public Board getBoard() {
        return new Board(board);
    }
}
