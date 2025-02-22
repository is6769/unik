package algorithms.semester1.practice2;

import java.util.concurrent.ThreadLocalRandom;

public class NeymanNumbers {

    public NeymanNumbers() {

        int val=ThreadLocalRandom.current().nextInt(15000,100000);
        for (int i = 0; i < 10; i++) {
            val= Integer.parseInt(String.valueOf(val*val).substring(2,7));
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        var n=new NeymanNumbers();
    }
}
