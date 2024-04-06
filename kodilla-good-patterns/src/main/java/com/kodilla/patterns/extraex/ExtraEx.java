package com.kodilla.patterns.extraex;

public class ExtraEx {
    public static void main(String[] args) {
        int[] table = {3,6,5,6,7,9,15,3,4,22,10};
        int minimal = findMinimal(table);
        int maximal = findMaximal(table);
        System.out.println("minimal: " + minimal);
        System.out.println("maximal: " + maximal);
    }

    private static int findMaximal(int[] table) {
        int maximal = table[0];
        for (int j : table) {
            if (j > maximal) {
                maximal = j;
            }
        }
        return maximal;
    }

    private static int findMinimal(int[] table) {
        int minimal = table[0];
        for (int j : table) {
            if (j < minimal) {
                minimal = j;
            }
        }
        return minimal;    }

}
