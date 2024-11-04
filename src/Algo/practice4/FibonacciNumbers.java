package Algo.practice4;

import java.util.Scanner;

public class FibonacciNumbers {

    public FibonacciNumbers() {
        var sc=new Scanner(System.in);
        System.out.println(nFibonacciNumber(sc.nextInt()));
    }

    private int nFibonacciNumber(int n){
        if (n==2 || n==1){
            return 1;
        }
        return nFibonacciNumber(n-1)+nFibonacciNumber(n-2);
    }

    public static void main(String[] args) {
        FibonacciNumbers fibonacciNumbers=new FibonacciNumbers();
    }
}
