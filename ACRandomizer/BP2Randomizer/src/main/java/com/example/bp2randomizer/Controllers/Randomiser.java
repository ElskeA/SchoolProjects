package com.example.bp2randomizer.Controllers;

import java.util.Random;

public class Randomiser {
    public static void generateAndPrintRandomNumbers(int count, int min, int max) {
        Random random = new Random();
        System.out.println("Generated Random Numbers:");
        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.print(randomNumber + " ");
        }
        System.out.println();
    }
}