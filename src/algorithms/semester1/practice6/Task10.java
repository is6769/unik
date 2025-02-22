package algorithms.semester1.practice6;

import java.io.*;
import java.util.*;


public class Task10 {
    public static void main(String[] args) {
        Queue<Integer> singleDigitNumbers = new LinkedList<>();
        Queue<Integer> doubleDigitNumbers = new LinkedList<>();

        try {
            createNumberFile("numbers.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    int number = Integer.parseInt(line.trim());

                    if (number >= 0 && number < 10) {
                        singleDigitNumbers.add(number);
                    } else if (number >= 10 && number < 100) {
                        doubleDigitNumbers.add(number);
                    }
                }
            }

            System.out.println("Однозначные числа:");
            while (!singleDigitNumbers.isEmpty()) {
                System.out.print(singleDigitNumbers.poll() + " ");
            }

            System.out.println("\n\nДвузначные числа:");
            while (!doubleDigitNumbers.isEmpty()) {
                System.out.print(doubleDigitNumbers.poll() + " ");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void createNumberFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Записываем тестовые данные
            int[] numbers = {5, 23, 4, 67, 8, 91, 1, 45, 3, 89};
            for (int number : numbers) {
                writer.println(number);
            }
        }
    }
}