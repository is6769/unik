package algorithms.semester1.practice6;
import java.util.Scanner;
import java.util.Random;

public class ArrayAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size (n): ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100) + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        int oddCount = 0;
        for (int num : arr) {
            if (num % 2 != 0) oddCount++;
        }
        System.out.println("a) Odd numbers count: " + oddCount);


        int squaresCount = 0;
        for (int num : arr) {
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num && num % 2 == 0) squaresCount++;
        }
        System.out.println("b) Even number squares count: " + squaresCount);


        int div3not5Count = 0;
        for (int num : arr) {
            if (num % 3 == 0 && num % 5 != 0) div3not5Count++;
        }
        System.out.println("c) Numbers divisible by 3 but not 5: " + div3not5Count);


        int conditionDCount = 0;
        for (int k = 0; k < arr.length; k++) {
            if (Math.pow(2, k) < arr[k] && arr[k] < factorial(k)) conditionDCount++;
        }
        System.out.println("d) Numbers satisfying 2^k < ak < k!: " + conditionDCount);


        int conditionECount = 0;
        for (int k = 1; k < arr.length - 1; k++) {
            double avg = (arr[k-1] + arr[k+1]) / 2.0;
            if (arr[k] < avg) conditionECount++;
        }
        System.out.println("e) Numbers less than neighbors average: " + conditionECount);


        int oddEvenIndexCount = 0;
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] % 2 != 0) oddEvenIndexCount++;
        }
        System.out.println("f) Odd numbers with even indices: " + oddEvenIndexCount);
    }

    private static long factorial(int n) {
        if (n <= 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}