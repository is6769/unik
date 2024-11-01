package Algo.practise4;

/*
1. из начала перекладываем на вспомогательный n-1
2. max->end
3. тк на вспомогательном сейчас пирамида из n-1 мы делаем vsp->end все

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

        hanoi(n-1,st,end,vsp);
        System.out.println(st+"->"+end);
        hanoi(n-1,vsp,st,end);
    }

    public static void main(String[] args) {
        HanoiTower hanoiTower=new HanoiTower();
    }
}
