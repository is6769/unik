package algorithms.semester1.practice6;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(11) + 10;
        int[] arr = new int[n];

        // Fill array with random numbers
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }

        // Print the array
        System.out.println("Array elements:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int count = 0;
        int sum = 0;

        for (int num : arr) {
            if (num % 5 == 0 && num % 7 != 0) {
                count++;
                sum += num;
            }
        }

        System.out.println("Count of numbers divisible by 5 but not by 7: " + count);
        System.out.println("Sum of numbers divisible by 5 but not by 7: " + sum);
    }
}