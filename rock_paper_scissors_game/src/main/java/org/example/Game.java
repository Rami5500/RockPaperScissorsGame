package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int userScore = 0;
    private int computerScore = 0;
    private int bestOf;
    private boolean game = true;
    private final Scanner scanner = new Scanner(System.in);
    private final Computer computer = new Computer();

    public void start() {
        System.out.println("Welcome to Rock Paper Scissors!");
        ready();
    }

    public void ready() {
        System.out.println("Are you ready to play the game? (Y/N)");
        String ready = scanner.nextLine();

        if (ready.equalsIgnoreCase("Y")) {
            gameType();
        } else {
            System.out.print("Game has finished!");
        }
    }

    public void gameType() {
        System.out.println("Choose the type of game: (1: Best of 1), (3: Best of 3), (5: Best of 5)");
        bestOf = scanner.nextInt();
        scanner.nextLine();
        resetScores();
        startGame();
    }

    private void resetScores() {
        userScore = 0;
        computerScore = 0;
    }

    public void startGame() {
        while (game) {
            System.out.println("Enter your choice (Rock, Paper, Scissors) or enter 'exit' to exit");
            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("exit")) {
                finish();
            } else {
                String computerChoice = computer.getComputerChoice();
                System.out.println("Computer picked: " + computerChoice);
                winner(userChoice, computerChoice);
                checkGameStatus();
            }
        }
    }

    public void winner(String userChoice, String computerChoice) {
        if (!userChoice.equalsIgnoreCase("Rock") && !userChoice.equalsIgnoreCase("Paper") && !userChoice.equalsIgnoreCase("Scissors")) {
            System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.");
            return;
        }

        if (userChoice.equalsIgnoreCase(computerChoice)) {
            System.out.println("It's a draw!");
        } else if ((computerChoice.equalsIgnoreCase("Rock") && userChoice.equalsIgnoreCase("Scissors")) ||
                (computerChoice.equalsIgnoreCase("Paper") && userChoice.equalsIgnoreCase("Rock")) ||
                (computerChoice.equalsIgnoreCase("Scissors") && userChoice.equalsIgnoreCase("Paper"))) {
            System.out.println("You have lost this round to the computer!");
            computerScore++;
        } else {
            System.out.println("You have won this round!");
            userScore++;
        }
        System.out.println("Score: User " + userScore + " - " + computerScore + " Computer");
    }

    private void checkGameStatus() {
        int roundsToWin = (bestOf / 2) + 1;

        if (userScore == roundsToWin) {
            displayResult("Congratulations! You won the game!");
        } else if (computerScore == roundsToWin) {
            displayResult("Unlucky, the computer won the game!");
        }
    }

    private void displayResult(String resultMessage) {
        System.out.println(resultMessage);
        System.out.println("Final Score: User " + userScore + " - " + computerScore + " Computer");
        System.out.println("Would you like to play again? (Y/N)");
        String restart = scanner.nextLine();
        if (restart.equalsIgnoreCase("Y")) {
            gameType();
        } else {
            finish();
        }
    }

    public void finish() {
        System.out.println("Thank you for playing the game!");
        game = false;
    }
}