package algorithms.semester1.practice6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task3 {

    public static boolean hasTwoConsecutiveZeros(int[] arr) {
        return IntStream.range(0, arr.length - 1)
                .anyMatch(i -> arr[i] == 0 && arr[i + 1] == 0);
    }

    public static boolean hasThreeConsecutiveZeros(int[] arr) {
        return IntStream.range(0, arr.length - 2)
                .anyMatch(i -> arr[i] == 0 && arr[i + 1] == 0 && arr[i + 2] == 0);
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                {1, 2, 0, 0, 4, 5},
                {1, 2, 0, 0, 0, 5},
                {1, 0, 2, 0, 3, 0},
                {0, 0, 0, 0, 0}
        };

        for (int i = 0; i < testArrays.length; i++) {
            System.out.println("\nТест " + (i + 1) + ":");
            System.out.println("Массив: " + Arrays.toString(testArrays[i]));

            boolean hasTwoZeros = hasTwoConsecutiveZeros(testArrays[i]);
            boolean hasThreeZeros = hasThreeConsecutiveZeros(testArrays[i]);

            System.out.println("Два нуля подряд: " + hasTwoZeros);
            System.out.println("Три нуля подряд: " + hasThreeZeros);
        }
    }
}
