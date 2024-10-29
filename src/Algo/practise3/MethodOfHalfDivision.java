package Algo.practise3;

import java.util.Scanner;

public class MethodOfHalfDivision {

    private double dividend;
    private double divisor;
    private MultiplyingNormal multiplyingNormal=new MultiplyingNormal();

    public MethodOfHalfDivision() {
        Scanner myObj = new Scanner(System.in);
        dividend = myObj.nextLong();
        divisor = myObj.nextLong();
        //halfDiv(Double.MIN_VALUE,);
    }

    private String f(String x){
        return dividend-divisor*x;
    }

    private void halfDiv(Double start,String end){
        String mid=multiplyingNormal.allLogic(end,"5");
        if(smallerThan(f(mid))<=0.00000001){
            System.out.println(start);
            return;
        }
        else if (f(mid)*f(start)<0){
            halfDiv(start,mid);
        }else{
            halfDiv(mid,end);
        }
    }

    private boolean smallerThan(String f) {

    }

    public static void main(String[] args) {
        var m=new MethodOfHalfDivision();
    }

}
