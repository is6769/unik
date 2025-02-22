package algorithms.semester1.practice4;

import java.util.Scanner;

public class DijkstraFunc {

    public DijkstraFunc() {
        var sc=new Scanner(System.in);
        System.out.println(dijkstraFunc(sc.nextInt()));
    }

    private int dijkstraFunc(int n){
        if (n==1){
            return 1;
        } else if (n%2==0) {
            return dijkstraFunc(n/2);
        }
        return dijkstraFunc((n-1)/2)+dijkstraFunc((n-1)/2+1);
    }

    public static void main(String[] args) {
        DijkstraFunc dijkstraFunc=new DijkstraFunc();
    }
}
