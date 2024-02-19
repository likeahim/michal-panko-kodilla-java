package com.kodilla.rps.ring;

import com.kodilla.rps.shapes.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameRing {

    public Scanner scanner = new Scanner(System.in);
    private int playerWins;
    private int computerWins;
    private Shape playersShape;
    private Shape computersShape;
    private final Player computer = new Player("Computer");
    private Player player;
    private Player winner;

    private final List<Shape> shapes = List.of(new Rock(), new Paper(), new Scissors(), new Spock(), new Lizard());
    private final int numberOfShapes = shapes.size();

    public void play() {
        boolean newGame = false;
        while (!newGame) {
            boolean end = false;
            int numberOfRounds = newGameStarter();
            while (!end) {
                printInfo();
                String move = getPlayerMove();
                switch (move) {
                    case "x" -> newGame = quit();
                    case "n" -> end = newGame();
                    case "1", "2", "3", "4", "5" -> makeAMove(move);

                    default -> System.out.println("no such a option");
                }
                if(newGame)
                    end = newGame;
                if (playerWins == numberOfRounds || computerWins == numberOfRounds) {
                    end = true;
                    setWinner();
                    newGame = !newGame();
                }
            }
        }
        scanner.close();
    }

    private void makeAMove(String move) {
        int i = Integer.parseInt(move) - 1;
        playersShape = shapes.get(i);
        int computerMove = new Random().nextInt(numberOfShapes);
        computersShape = shapes.get(computerMove);
        if (playersShape.getBullies().contains(computersShape)) {
            computerWins++;
            battleInfo(computer);
        } else if (playersShape.getVictims().contains(computersShape)) {
            playerWins++;
            battleInfo(player);
        } else
            drawInfo(computersShape, playersShape);
    }

    private String getPlayerMove() {
        return scanner.nextLine();

    }

    private void battleInfo(Player player) {
        System.out.println(this.playersShape + " vs " + this.computersShape + "\n" +
                           player.getName() + " wins this battle\n" +
                           playerWins + " to " + computerWins);
    }

    private void drawInfo(Shape computersShape, Shape playersShape) {
        System.out.println(playersShape + " vs " + computersShape + "\n" +
                "draw!\n" +
                playerWins + " to " + computerWins);
    }

    private boolean newGame() {
        System.out.println("""
                Do you want to start new game?
                y -> yes, new game
                n -> no""");
        String answer = scanner.nextLine();
        return answer.equals("y");
    }

    private int newGameStarter() {
        System.out.println("NEW GAME");
        playerWins = 0;
        computerWins = 0;
        String name = enterName();
        this.player = new Player(name);
        return enterNumberOfRounds();
    }

    private boolean quit() {
        System.out.println("""
                Do you really want to exit?
                y -> yes, exit
                n -> no, resume""");
        String answer = scanner.nextLine();
        return answer.equals("y");
    }

    private void printInfo() {
        System.out.println("Options: \n" +
                           "1 -> play Rock\n" +
                           "2 -> play Paper\n" +
                           "3 -> play Scissors\n" +
                           "4 -> play Spock\n" +
                           "5 -> play Lizard\n" +
                           "x -> end of game\n" +
                           "n -> new game");
    }

    private void setWinner() {
        if(playerWins > computerWins)
            winner = player;
        else
            winner = computer;
        System.out.println("the winner is " + winner.getName());
    }

    private int enterNumberOfRounds() {
        System.out.println("Enter number of rounds to win: ");
        int rounds = scanner.nextInt();
        scanner.nextLine();
        return rounds;
    }

    private String enterName() {
        System.out.println("Enter your name:");
        return scanner.nextLine();
    }

}
