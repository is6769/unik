package algorithms.semester1.practice6;

import java.util.Arrays;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        double[] orderedArray = {9.5, 7.2, 5.1, 3.8, 1.4};
        double[] unorderedArray = {5.2, 8.1, 3.7, 6.4, 2.9};
        double[] randomArray = generateRandomArray(5);

        System.out.println("Упорядоченный массив: " + Arrays.toString(orderedArray));
        System.out.println("Упорядочен по убыванию: " + isDescending(orderedArray));

        System.out.println("\nНеупорядоченный массив: " + Arrays.toString(unorderedArray));
        System.out.println("Упорядочен по убыванию: " + isDescending(unorderedArray));

        System.out.println("\nСлучайный массив: " + Arrays.toString(randomArray));
        System.out.println("Упорядочен по убыванию: " + isDescending(randomArray));
    }

    public static boolean isDescending(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static double[] generateRandomArray(int size) {
        Random random = new Random();
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Math.round(random.nextDouble() * 100.0) / 10.0;
        }
        return arr;
    }
}