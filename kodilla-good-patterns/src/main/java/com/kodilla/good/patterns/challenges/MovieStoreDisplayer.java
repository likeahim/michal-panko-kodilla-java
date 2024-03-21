package com.kodilla.good.patterns.challenges;

public class MovieStoreDisplayer {
    public static void main(String[] args) {
        MovieStore ms = new MovieStore();
        ms.displayTitles(ms.getMovies());
    }
}
