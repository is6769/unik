package Algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Factorize {
    private final HashMap<Integer,Integer> resLst=new HashMap<Integer,Integer>();

    public Factorize() {
        Scanner myObj = new Scanner(System.in);
        int n = myObj.nextInt();
        if (isPrime(n)){
            System.out.println("1*"+n);
        }else {
            factorizate(n);
        }
        resLst.keySet().forEach(x-> System.out.print(x+"^"+resLst.get(x)+" + "));
        System.out.print("0");

    }



    private void factorizate(int a){
        var factArr= findDivs(a);
        for (int mn: factArr) {
            if (isPrime(mn)){
                resLst.computeIfPresent(mn,(_, oldValue)->++oldValue);
                resLst.putIfAbsent(mn, 1);
            }else{
                factorizate(mn);
            }
        }
    }

    private int[] findDivs(int n) {
        for (int i = 2; i < ((int)(Math.sqrt(n)))+1; i++) {
            if (n%i==0){
                return new int[]{i,n/i};
            }
        }
        return new int[]{0,0};
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
        var f=new Factorize();
    }
}
