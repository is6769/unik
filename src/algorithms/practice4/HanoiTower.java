package algorithms.practice4;

import java.util.Scanner;

public class HanoiTower {

    public HanoiTower() {
        var sc= new Scanner(System.in);
        hanoi(sc.nextInt(),"A","B","C");
    }

    private void hanoi(int n,String st,String vsp,String end){
        if (n==1){
            System.out.println(st + "->" + end);
            return;
        }

        hanoi(n-1,st,end,vsp);
        System.out.println(st+"->"+end); //max->end
        hanoi(n-1,vsp,st,end);
    }

    public static void main(String[] args) {
        HanoiTower hanoiTower=new HanoiTower();
    }
}
