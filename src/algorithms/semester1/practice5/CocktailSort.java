package algorithms.semester1.practice5;

import java.util.ArrayList;
import java.util.Arrays;

public class CocktailSort {

    public CocktailSort() {
        sort(new ArrayList<>(Arrays.asList(new Integer[]{3, 2, 3, 423, 23, 5, 234, 234, 3, 1})));
    }

    public void sort(ArrayList<Integer> list){
        var start=1;
        var end=list.size();
        var swaps=1;
        while (swaps!=0) {
            swaps=0;
            for (int i = start; i < end; i++) {
                if (list.get(i - 1) > list.get(i)) {
                    var temp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, temp);
                    swaps++;
                }
            }
            end--;
            for (int j = end-1; j > start-1; j--) {
                if (list.get(j) < list.get(j-1)) {
                    var temp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                    swaps++;
                }
            }
            start++;
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        var t=new CocktailSort();
    }
}
