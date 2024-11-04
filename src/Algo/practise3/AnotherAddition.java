package Algo.practise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class AnotherAddition {

    public AnotherAddition() {

        Scanner myObj = new Scanner(System.in);
        String n1 = myObj.next();
        String n2 = myObj.next();

        var number1=new ArrayList<Integer>();
        var number2=new ArrayList<Integer>();

        number1.add(0);
        number2.add(0);
        fillArrays(number1,number2,n1,n2);

        if (number1.size() > number2.size()) {
            completeArrays(number1.size() - number2.size(), number2);
        } else {
            completeArrays(number2.size() - number1.size(), number1);
        }

        System.out.println(number1);
        System.out.println(number2);
        System.out.println();



        plus(number1,number2);
    }

    private void completeArrays(int i,ArrayList<Integer> lst){
        for (int j = 0; j < i; j++) {
            lst.add(0,0);
        }
    }

    private void fillArrays(ArrayList<Integer> number1, ArrayList<Integer> number2, String n1, String n2) {
        if ('-' == n1.charAt(0)) n1=n1.replace("-","");
        if ('-' == n2.charAt(0)) n2=n2.replace("-","");
        Arrays.stream(n1.split("")).forEach(x->number1.add(Integer.valueOf(x)));
        Arrays.stream(n2.split("")).forEach(x->number2.add(Integer.valueOf(x)));
    }

    private void plus(ArrayList<Integer> number1,ArrayList<Integer> number2){
        var interLst=new ArrayList<Integer>();
        for (int i = 0; i < number1.size(); i++) {
            interLst.add(0);
        }
        for (int i = number1.size()-1; i > -1; i--) {
            if(number1.get(i)+number2.get(i)>9){
                number1.set(i,number1.get(i)+number2.get(i)-10);
                interLst.set(i-1,1);
            }else{
                number1.set(i,number1.get(i)+number2.get(i));
            }
        }
        System.out.println();
        System.out.println(number1);
        System.out.println(interLst);


        if(interLst.contains(1))plus(number1,interLst);
        else System.out.println("result:"+number1.stream().map(String::valueOf).reduce(String::concat).get().replaceFirst("^0+(?!$)", ""));

    }



    public static void main(String[] args) {
        var a=new AnotherAddition();
    }
}
