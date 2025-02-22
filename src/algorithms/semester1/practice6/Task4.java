package algorithms.semester1.practice6;

import java.util.LinkedList;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        Random random = new Random();
        int size = 5;

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }


        System.out.println("Список: " + list);


        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        System.out.println("Сумма всех чисел: " + sum);
    }
}