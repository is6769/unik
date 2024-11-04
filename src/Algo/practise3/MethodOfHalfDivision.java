package Algo.practise3;

import java.util.Arrays;
import java.util.Scanner;

public class MethodOfHalfDivision {

    private String dividend;
    private String divisor;
    private final MultiplyingNormal multiplyingNormal=new MultiplyingNormal();
    private final AdditionSubtraction additionSubtraction=new AdditionSubtraction();

    public MethodOfHalfDivision() {
        Scanner myObj = new Scanner(System.in);
        dividend = myObj.next();
        divisor = myObj.next();
        halfDiv("0",dividend);
    }

    private String f(String x){
        return additionSubtraction.allLogic(dividend,"-",multiplyingNormal.allLogic(divisor,x));
    }

    private void halfDiv(String start,String end){
        var midB=multiplyingNormal.allLogic(additionSubtraction.allLogic(end,"+",start),"5");
        var mid5=midB;
        midB=midB.substring(0,midB.length()-1);
        String mid=(Integer.parseInt(mid5.substring(mid5.length()-1))%2==0) ? midB : additionSubtraction.allLogic(midB, "+","1");
        var currVal=f(mid);
        if (currVal.charAt(0)!='-' && isSmallerOrEqualsThan(currVal,divisor)) {
            System.out.println("частное: "+mid);
            System.out.println("остаток: "+currVal);
        }
        else if(currVal.charAt(0)=='-'){
            halfDiv(start,mid);
        }else{
            halfDiv(mid,end);
        }
    }

    private boolean isSmallerOrEqualsThan(String result,String divisor) {
        if (result.length()==divisor.length()){
            for (int i = 0; i < result.length(); i++) {
                if ((int)result.charAt(i)-'0'<(int)divisor.charAt(i) -'0'){
                    return true;
                } else if ((int)result.charAt(i) - '0'>=(int)divisor.charAt(i) -'0') {
                    return false;
                }
            }
        }
        return result.length()<=divisor.length();
    }

    public static void main(String[] args) {
        var m=new MethodOfHalfDivision();
    }

}
