package com.kodilla.rps;

import com.kodilla.rps.ring.GameRing;

public class RpsRunner {
    public static void main(String[] args) {

        GameRing gameRing = new GameRing();
        gameRing.play();
        System.out.println("goodbye");
    }
}
