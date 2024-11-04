package Algo.practice4;

/*
1. из начала перекладываем на вспомогательный n-1
2. max->end
3. на vsp сейчас n-1,на end самый большой, значит мы должны переложить n-1 из vsp в end, используя пустой st как новый vsp.

*/


public class HanoiTower {

    public HanoiTower() {
        hanoi(3,"A","B","C");
    }

    private void hanoi(int n,String st,String vsp,String end){
        if (n==1){
            System.out.println(st + "->" + end);
            return;
        }

        hanoi(n-1,st,end,vsp);//из начала перекладываем на вспомогательный n-1
        System.out.println(st+"->"+end); //max->end
        hanoi(n-1,vsp,st,end); //на vsp сейчас n-1,на end самый большой, значит мы должны переложить n-1 из vsp в end, используя пустой st как новый vsp.
    }

    public static void main(String[] args) {
        HanoiTower hanoiTower=new HanoiTower();
    }
}
