package Algo.practice3;

import java.util.ArrayList;
import java.util.Arrays;

public class AdditionSubtraction {

    public AdditionSubtraction() {
//        Scanner myObj = new Scanner(System.in);
//        String n1 = myObj.next();
//        String sign= myObj.next();
//        String n2 = myObj.next();
//        System.out.println(allLogic(n1,sign,n2));
    }

    public String allLogic(String n1, String sign, String n2){
        var number1=new ArrayList<Integer>();
        var number2=new ArrayList<Integer>();
        number1.add(0);
        number2.add(0);

        String[] signs={
                ('-' == n1.charAt(0)) ? "-" : "+",
                sign,
                ('-' == n2.charAt(0)) ? "-" : "+",
        };

        fillArrays(number1,number2,n1,n2);
        if (number1.size() > number2.size()) {
            completeArrays(number1.size() - number2.size(), number2);
        } else {
            completeArrays(number2.size() - number1.size(), number1);
        }


        return calculate(signs,number1,number2);
    }

    private String calculate(String[] signs, ArrayList<Integer> number1, ArrayList<Integer> number2) {
        if (Arrays.stream(signs).allMatch("+"::equals)) return add(number1,number2);
        else if (signs[0].equals("-") && signs[1].equals("-") && signs[2].equals("+")) return "-"+add(number1,number2);
        else if (signs[0].equals("+") && signs[1].equals("-") && signs[2].equals("-")) return add(number1,number2);
        else if (signs[0].equals("-") && signs[1].equals("+") && signs[2].equals("-")) return "-"+add(number1,number2);

        else if (Arrays.stream(signs).allMatch("-"::equals) ||
                signs[0].equals("-") && signs[1].equals("+") && signs[2].equals("+"))
        {
            if (isBigger(number1,number2)){
                return "-"+subtract(number1,number2);
            }else{
                return subtract(number2,number1);
            }
        } else if (signs[0].equals("+") && signs[1].equals("+") && signs[2].equals("-") ||
                signs[0].equals("+") && signs[1].equals("-") && signs[2].equals("+"))
        {
            if (isBigger(number1,number2)){
                return subtract(number1,number2);
            }else{
                return "-"+subtract(number2,number1);
            }
        }

        return "Oops, something went wrong, please, check your input";
    }

    private void fillArrays(ArrayList<Integer> number1, ArrayList<Integer> number2, String n1, String n2) {
        if ('-' == n1.charAt(0)) n1=n1.replace("-","");
        if ('-' == n2.charAt(0)) n2=n2.replace("-","");
        Arrays.stream(n1.split("")).forEach(x->number1.add(Integer.valueOf(x)));
        Arrays.stream(n2.split("")).forEach(x->number2.add(Integer.valueOf(x)));
    }

    private void completeArrays(int i,ArrayList<Integer> lst){
        for (int j = 0; j < i; j++) {
            lst.add(0,0);
        }
    }

    private boolean isBigger(ArrayList<Integer> number1, ArrayList<Integer> number2){
        for (int i = 0; i < number1.size(); i++) {
            if (number1.get(i)<number2.get(i)){
                return false;
            } else if (number1.get(i)>number2.get(i)) {
                return true;
            }
        }
        return true;
    }
    
    private String add(ArrayList<Integer> number1, ArrayList<Integer> number2){
        for (int i = number1.size()-1; i > -1 ; i--) {
            if (number1.get(i)+number2.get(i)>9){
                number2.set(i,number1.get(i)+number2.get(i)-10);
                number1.set(i-1,number1.get(i-1)+1);
            }else{
                number2.set(i,number1.get(i)+number2.get(i));
            }
        }
        return number2.stream().map(String::valueOf).reduce((x,y)->x+y).get().replaceFirst("^0+(?!$)", "");
    }

    private String subtract(ArrayList<Integer> number1, ArrayList<Integer> number2){
        for (int i = number1.size()-1; i > -1 ; i--) {
            if (number1.get(i)-number2.get(i)<0){
                number2.set(i,number1.get(i)+10-number2.get(i));
                number1.set(i-1,number1.get(i-1)-1);
            }else{
                number2.set(i,number1.get(i)-number2.get(i));
            }
        }
        return number2.stream().map(String::valueOf).reduce((x,y)->x+y).get().replaceFirst("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        var c=new AdditionSubtraction();
    }

}
