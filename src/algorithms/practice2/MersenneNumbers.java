package algorithms.practice2;

import java.util.Scanner;

public class MersenneNumbers {

    public MersenneNumbers() {
        Scanner myObj = new Scanner(System.in);
        int p = myObj.nextInt();
        if(p==1 || p==2){
            System.out.println("Число простое");
        }else {
            check(p);
        }

    }

    private void check(int p){
        var k=1;
        long s= 4L;
        long m= (long) (Math.pow(2,p)-1);
        while (k!=p-1){
            s= ((s*s-2)%m);
            k+=1;
        }
        System.out.println( s==0 || s==m? "Число простое" : "Число непростое");
    }

    public static void main(String[] args) {
        var mNumber=new MersenneNumbers();
    }

}
