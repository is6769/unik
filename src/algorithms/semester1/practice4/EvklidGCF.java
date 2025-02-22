package algorithms.semester1.practice4;

import java.util.Scanner;

public class EvklidGCF {

    public EvklidGCF() {

        Scanner myObj = new Scanner(System.in);
        System.out.println(gcf(myObj.nextInt(),myObj.nextInt()));
    }

    private int gcf(int a, int b) {
        if (a==b){
            return a;
        }
        return (a>b) ? gcf(a-b,b) : gcf(a, b-a);
    }

    public static void main(String[] args) {
        EvklidGCF evklidGCF=new EvklidGCF();
    }
}
