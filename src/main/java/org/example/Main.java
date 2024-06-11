package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        game.getBoard().printBoard();

        System.out.println("X will play first. Enter a slot number to place X in:");

        while (game.checkWinner() == null) {
            int numInput;

            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input; re-enter slot number:");
                in.next(); // Clear the invalid input
                continue;
            }

            if (game.play(numInput)) {
                game.getBoard().printBoard();
            } else {
                System.out.println("Slot already taken; re-enter slot number:");
            }
        }

        String winner = game.checkWinner();
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }

        in.close();
    }
}
