package Algo.practice3;

import java.util.Scanner;

public class Multiplying {

    AdditionSubtraction additionSubtraction=new AdditionSubtraction();
    MultiplyingNormal multiplyingNormal=new MultiplyingNormal();

    public Multiplying() {
        Scanner myObj = new Scanner(System.in);
        String n1 = myObj.next();
        String n2 = myObj.next();

        System.out.println("Карацуба:              "+multiply(n1,n2));
        System.out.println("Стандартное умножение: "+multiplyingNormal.allLogic(n1,n2));
    }


    private String[] fillStrings(String n1, String n2) {
        var sb1=new StringBuilder(n1);
        var sb2=new StringBuilder(n2);
        if (sb1.length()>=sb2.length()){
            if(sb1.length()%2!=0){
                sb1.insert(0,"0");
            }
            while (sb2.length()<sb1.length()){
                sb2.insert(0,"0");
            }
        }else {
            if(sb2.length()%2!=0){
                sb2.insert(0,"0");
            }
            while (sb1.length()<sb2.length()){
                sb1.insert(0,"0");
            }
        }
        return new String[]{sb1.toString(), sb2.toString()};
    }

    private String multiply(String number1, String number2) {
        if (isSingleDigit(number1) || isSingleDigit(number2)){
            return multiplyingNormal.allLogic(number1,number2);
        }
        var filledStrings=fillStrings(number1,number2);
        number1=filledStrings[0];
        number2=filledStrings[1];

        String x="1";
        for (int i = 0; i < number1.length()/2; i++) {
            x=multiplyingNormal.allLogic(x,"10");
        }
        var x2=multiplyingNormal.allLogic(x,x);
        var a=number1.substring(0,number1.length()/2);
        var b=number1.substring(number1.length()/2);
        var c=number2.substring(0,number2.length()/2);
        var d=number2.substring(number2.length()/2);

        var ac=multiply(a,c);
        var bd=multiply(b,d);
        var other=multiply(additionSubtraction.allLogic(a,"+",b),additionSubtraction.allLogic(c,"+",d));

        var acx2=multiplyingNormal.allLogic(ac,x2);
        var bracket=additionSubtraction.allLogic(additionSubtraction.allLogic(other,"-",ac),"-",bd);
        var bracketx=multiplyingNormal.allLogic(bracket,x);

        var result=additionSubtraction.allLogic(additionSubtraction.allLogic(acx2,"+",bracketx),"+",bd);

        return result.replaceFirst("^0+(?!$)", "");
    }

    private boolean isSingleDigit(String n) {
        return (n.replaceFirst("^0+(?!$)", "")).length()<=1;
    }

    public static void main(String[] args) {
        var m=new Multiplying();
    }

}
