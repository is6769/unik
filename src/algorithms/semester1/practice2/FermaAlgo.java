package algorithms.semester1.practice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FermaAlgo {

    private final HashMap<Integer,Integer> resLst=new HashMap<Integer,Integer>();

    public FermaAlgo() {
        Scanner myObj = new Scanner(System.in);
        int n = myObj.nextInt();
        if (isPrime(n)){
            System.out.println("1*"+n);
        }else{
            factorizate(n);
        }
        resLst.keySet().forEach(x-> System.out.print(x+"^"+resLst.get(x)+" + "));
        System.out.print("0");

    }

    private void factorizate(int a){
        var factArr= factorizateFerma(a);
        for (int mn: factArr) {
            if (isPrime(mn)){
                resLst.computeIfPresent(mn,(_, oldValue)->++oldValue);
                resLst.putIfAbsent(mn, 1);
            }else{
                factorizate(mn);
            }
        }
    }

    private int[] factorizateFerma(int n){
        var A=(int)Math.sqrt(n);
        var k= Math.sqrt(n)%1==0 ?0:1 ;
        while((Math.sqrt(Math.pow(A+k,2)-n))%1!=0){
            k++;
        }
        var b=Math.sqrt((Math.pow(A+k,2)-n));
        var a=Math.sqrt(Math.pow(A+k,2));


        return new int[]{(int) (a - b), (int) (a + b)};
        //System.out.println(a-b);
        //System.out.println(a+b);
    }

    private boolean isPrime(int a){
        if (a==2) return true;
        ArrayList<Integer> lst=new ArrayList<Integer>();
        for (int i = 2; i < a+1; i++) {
            lst.add(i);
        }
        var n=2;
        lst= (ArrayList<Integer>) lst.stream().filter(x->x%n!=0 || x==n).collect(Collectors.toList());
        return isPrime(lst,1).contains(a);
    }

    private ArrayList<Integer> isPrime(ArrayList<Integer> lst, int itNumber){
        var n=lst.get(itNumber);
        if(!lst.stream().anyMatch(x->x%n==0 && x!=n)){
            return lst;
        }
        lst= (ArrayList<Integer>) lst.stream().filter(x->x%n!=0 || x==n).collect(Collectors.toList());

        return isPrime(lst,itNumber+1);
    }

    public static void main(String[] args) {
        FermaAlgo fermaAlgo=new FermaAlgo();
    }
}
