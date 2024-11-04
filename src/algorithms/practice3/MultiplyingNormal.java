package algorithms.practice3;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplyingNormal {

    AdditionSubtraction additionSubtraction=new AdditionSubtraction();

    public MultiplyingNormal() {
//        Scanner myObj = new Scanner(System.in);
//        String n1 = myObj.next();
//        String n2 = myObj.next();
//        System.out.println(allLogic(n1,n2));
    }

    public String allLogic(String n1, String n2){
        var number1=new ArrayList<Integer>();
        var number2=new ArrayList<Integer>();
        number1.add(0);
        number2.add(0);

        String[] signs={
                ('-' == n1.charAt(0)) ? "-" : "+",
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
        var result=multiply(number1,number2);
        result=result.replaceFirst("^0+(?!$)", "");
        if (Arrays.stream(signs).allMatch("+"::equals)) return result;
        else if (Arrays.stream(signs).allMatch("-"::equals)) return result;
        else return "-"+result;
    }

    private String multiply(ArrayList<Integer> number1, ArrayList<Integer> number2) {
        String result="0";
        for (int i = 0; i < number2.size(); i++) {
            var currentIterationResult=multiplyOnOneNumber(number1, number2.get(number2.size()-1-i))+"0".repeat(i);
            result=additionSubtraction.allLogic(result,"+",currentIterationResult);
        }
        return result;
    }

    private void fillArrays(ArrayList<Integer> number1, ArrayList<Integer> number2, String n1, String n2) {
        if ('-' == n1.charAt(0)) n1=n1.replace("-","");
        if ('-' == n2.charAt(0)) n2=n2.replace("-","");
        Arrays.stream(n1.split("")).forEach(x->number1.add(Integer.valueOf(x)));
        Arrays.stream(n2.split("")).forEach(x->number2.add(Integer.valueOf(x)));
    }


    private String multiplyOnOneNumber(ArrayList<Integer> number1, Integer factor) {
        var interLst=new ArrayList<Integer>();
        for (int i = 0; i < number1.size(); i++) {
            interLst.add(0);
        }
        for (int i = number1.size()-1; i > -1; i--) {
            var product=number1.get(i)*factor;
            if(product>9){
                if (interLst.get(i)+(product)%10>9){
                    interLst.set(i,(interLst.get(i)+(product))%10);
                    interLst.set(i-1,interLst.get(i-1)+1);
                }else {
                    interLst.set(i, interLst.get(i) + (product) % 10);
                }
                interLst.set(i-1,interLst.get(i-1)+product/10);
            }else{
                if (interLst.get(i)+product>9){
                    interLst.set(i-1,interLst.get(i-1)+(interLst.get(i)+product)/10);
                }
                interLst.set(i,(interLst.get(i)+product)%10);
            }
        }
        return interLst.stream().map(String::valueOf).reduce((x,y)->x+y).get();
    }

    private void completeArrays(int i,ArrayList<Integer> lst){
        for (int j = 0; j < i; j++) {
            lst.add(0,0);
        }
    }

    public static void main(String[] args) {
        var m=new MultiplyingNormal();
    }
}
