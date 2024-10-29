package Algo.practise3;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AnotherAddition {

    public AnotherAddition() {
        var number1=new ArrayList<Integer>();
        var number2=new ArrayList<Integer>();
        number1.add(0);//добавил по нулю в массивы чтобы не париться с доп разрядом
        number2.add(0);
        initTest(number1,number2);

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

    private void initTest(ArrayList<Integer> number1,ArrayList<Integer> number2){
        number1.add(8);
        number1.add(2);
        number1.add(9);
        number1.add(0);
        number1.add(9);


        number2.add(9);
        number2.add(4);
        number2.add(7);
        number2.add(8);



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
        else System.out.println("result:"+number1);

    }



    public static void main(String[] args) {
        var a=new AnotherAddition();
    }
}
