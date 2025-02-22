package algorithms.semester1.practice6;

import java.util.LinkedList;

public class Task8 {
    public static <T> void shiftRight(LinkedList<T> list, int n) {
        if (list.size() <= 1 || n == 0) {
            return;
        }

        n = n % list.size();
        for (int i = 0; i < n; i++) {
            list.addFirst(list.removeLast());
        }
    }

    public static <T> void shiftLeft(LinkedList<T> list, int n) {
        if (list.size() <= 1 || n == 0) {
            return;
        }

        n = n % list.size();
        for (int i = 0; i < n; i++) {
            list.addLast(list.removeFirst());
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        System.out.println("Исходный список: " + list);

        int rightShift = 2;
        System.out.println("\nСдвиг вправо на " + rightShift + " позиции:");
        shiftRight(list, rightShift);
        System.out.println("Результат: " + list);

        int leftShift = 1;
        System.out.println("\nСдвиг влево на " + leftShift + " позицию:");
        shiftLeft(list, leftShift);
        System.out.println("Результат: " + list);

        System.out.println("\nСдвиг вправо на 7 позиций (больше размера списка):");
        shiftRight(list, 7);
        System.out.println("Результат: " + list);

        LinkedList<Integer> smallList = new LinkedList<>();
        for (int i = 1; i <= 3; i++) {
            smallList.add(i);
        }
        System.out.println("Исходный список: " + smallList);
        System.out.println("Сдвиг влево на 2 позиции:");
        shiftLeft(smallList, 2);
        System.out.println("Результат: " + smallList);
    }
}