package org.example;

public class TicTacToeTest {
    public static void main(String[] args) {
        testInitialBoard();
        testPlay();
        testCheckWinner();
        testBoardPrinting();
        System.out.println("All tests passed.");
    }

    public static void testInitialBoard() {
        TicTacToe game = new TicTacToe();
        Board board = game.getBoard();
        String[] initialBoard = new String[9];
        for (int i = 0; i < 9; i++) {
            initialBoard[i] = String.valueOf(i + 1);
        }
        assert Arrays.equals(board.getBoard(), initialBoard) : "Initial board setup is incorrect.";
    }

    public static void testPlay() {
        TicTacToe game = new TicTacToe();
        assert game.play(1) : "Playing in slot 1 should be allowed.";
        assert !game.play(1) : "Playing in slot 1 again should not be allowed.";
        assert game.getTurn().equals("O") : "After X, it should be O's turn.";
        assert game.play(2) : "Playing in slot 2 should be allowed.";
        assert game.getTurn().equals("X") : "After O, it should be X's turn.";
    }

    public static void testCheckWinner() {
        TicTacToe game = new TicTacToe();
        assert game.checkWinner() == null : "Initially, there should be no winner.";
        game.play(1);
        game.play(4);
        game.play(2);
        game.play(5);
        game.play(3);
        assert game.checkWinner().equals("X") : "X should be the winner.";

        game = new TicTacToe();
        game.play(1);
        game.play(2);
        game.play(4);
        game.play(5);
        game.play(7);
        game.play(8);
        assert game.checkWinner() == null : "There should be no winner yet.";
        game.play(3);
        game.play(6);
        game.play(9);
        assert game.checkWinner().equals("draw") : "The game should be a draw.";
    }

    public static void testBoardPrinting() {
        TicTacToe game = new TicTacToe();
        Board board = game.getBoard();
        String expectedBoard = "|---|---|---|\n"
                             + "| 1 | 2 | 3 |\n"
                             + "|-----------|\n"
                             + "| 4 | 5 | 6 |\n"
                             + "|-----------|\n"
                             + "| 7 | 8 | 9 |\n"
                             + "|---|---|---|\n";
        assert board.printBoard().equals(expectedBoard) : "Board printing is incorrect.";
    }
}
