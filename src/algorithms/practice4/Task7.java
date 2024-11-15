package algorithms.practice4;

import java.util.Arrays;
import java.util.List;


public class Task7 {

    private int SIZE=8;

    List<Integer> hashMap =  Arrays.asList(new Integer[SIZE]);

    public Task7() {
        init();
    }

    private void init(){
        int[] lst={86,90,27,29,38,30,40};
        for (int item: lst) {
            var index=hash(item);
            while (hashMap.get(index) != null) {
                index++;
            }

            hashMap.set(index,item);
        }
    }

    private int hash(int i){
        return i%7;
    }

    public static void main(String[] args) {
        var t=new Task7();
    }
}
