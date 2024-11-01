package Algo.practise2;

import java.util.ArrayList;
import java.util.Scanner;

public class SundaramsSieve {
    public SundaramsSieve() {

        Scanner myObj = new Scanner(System.in);
        var n = myObj.nextInt();
        var lst=new ArrayList<Integer>();
        n=(n-1)/2;
        for (int i = 1; i < n+1; i++) {
            lst.add(i);
        }
        sieve(lst,n);
    }

    private void sieve(ArrayList<Integer> lst,int n){
        for (int i = 1;  i+i+1+2*i*(i+1)<=n; i++) {
            for (int j = i; i+j+2*i*j<=n; j++) {
                lst.set(i+j+2*i*j-1,0);
            }
        }
        for (int i = 0; i < n; i++) {
            if(lst.get(i)!=0){
                System.out.print(lst.get(i)*2+1);
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        var s=new SundaramsSieve();
    }
}
