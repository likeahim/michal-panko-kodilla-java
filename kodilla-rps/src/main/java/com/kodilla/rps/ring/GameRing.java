package com.kodilla.rps.ring;

import com.kodilla.rps.shapes.Paper;
import com.kodilla.rps.shapes.Rock;
import com.kodilla.rps.shapes.Scissors;
import com.kodilla.rps.shapes.Shape;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameRing {

    public Scanner scanner = new Scanner(System.in);
    private int playerWins = 0;
    private int computerWins = 0;
    private Shape playersShape;
    private Shape computersShape;
    private Player computer = new Player("Computer");
    private Player player;
    private List<Shape> shapes = List.of(new Rock(), new Paper(), new Scissors());

    public void play() {
        boolean end = false;
        boolean newGame = false;
        while(!newGame) {
            String name = enterName();
            this.player = new Player(name);
            int numberOfRounds = enterNumberOfRounds();
            while (!end) {
                printInfo();
                String move = getPlayerMove();
                switch (move) {
                    case "x" -> end = quit();
                    case "n" -> newGame = newGame();
                    case "1", "2", "3" -> {
                        int i = Integer.parseInt(move);
                        playersShape = shapes.get(i + 1);
                    }
                    default -> System.out.println("FALSE MOVE, TRY AGAIN");
                }
                int computerMove = new Random().nextInt(3) + 1;
                computersShape = shapes.get(computerMove);
                if(computersShape.equals(playersShape.getBully())) {
                    computerWins++;
                    battleInfo(computer, computersShape, playersShape);
                }
                else if(computersShape.equals(playersShape.getVictim())) {
                    playerWins++;
                    battleInfo(player, computersShape, playersShape);
                }
                else
                    drawInfo(computersShape, playersShape);
                if(playerWins == numberOfRounds || computerWins == numberOfRounds) {
                    end = true;
                    scanner.close();
                }
            }
        }
    }

    private void battleInfo(Player player, Shape computersShape, Shape playersShape) {
        System.out.println(playersShape + " vs " + computersShape + "\n" +
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
                Do you really want to stop and start new game?
                y -> yes, new game
                n -> no, stay and play""");
        String answer = scanner.nextLine();
        return answer.equals("y");
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
                "x -> end of game\n" +
                "n -> new game");
    }

    private String getPlayerMove() {
        return scanner.nextLine();

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

    private void startInfo() {

    }
}
