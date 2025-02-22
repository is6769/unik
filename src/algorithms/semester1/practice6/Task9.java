package algorithms.semester1.practice6;

import java.io.*;
import java.util.Stack;

public class Task9 {
    public static void main(String[] args) {
        try {
            createTestFile("test.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
                String line;
                Stack<Character> stack = new Stack<>();

                System.out.println("Исходный текст:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);

                    for (char c : line.toCharArray()) {
                        stack.push(c);
                    }

                    System.out.print("Перевернутая строка: ");
                    while (!stack.empty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.println("\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void createTestFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Hello, World!");
            writer.println("Java Programming");
            writer.println("Stack Example");
        }
    }
}