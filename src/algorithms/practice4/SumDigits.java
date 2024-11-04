package algorithms.practice4;

import java.util.Scanner;

public class SumDigits {

    public SumDigits() {
        var sc=new Scanner(System.in);
        var inNumber= sc.next();
        System.out.println(sumDigits(inNumber));
    }

    private int sumDigits(String number) {
        var lastIndex=number.length()-1;
        if (number.length()==1){
            return number.charAt(lastIndex)-'0';
        }
        return ((int)number.charAt(lastIndex)-'0')+sumDigits(number.substring(0,lastIndex));
    }

    public static void main(String[] args) {
        SumDigits sumDigits=new SumDigits();
    }
}
