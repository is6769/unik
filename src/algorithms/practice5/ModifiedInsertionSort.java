package algorithms.practice5;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class ModifiedInsertionSort {

    public ModifiedInsertionSort() {
        ArrayList<Integer> lst= new ArrayList<>(IntStream.generate(() -> new Random().nextInt(100)).limit(10).boxed().toList());
        modifiedInsertionSort(lst);
    }

    private void modifiedInsertionSort(ArrayList<Integer> lst) {
        System.out.println(lst);
        for (int i = 1; i < lst.size(); i++) {
            lst.add(binaryIndexSearch(lst,0,i), lst.get(i));
            lst.remove(i+1);
        }
        System.out.println(lst);
    }

    private int binaryIndexSearch(ArrayList<Integer> lst, int low, int high) {
        low--;
        var element=lst.get(high);
        while (high-low>1){
            var mid=(low+high)/2;
            if (element<lst.get(mid)){
                high=mid;
            } else if (lst.get(mid)==element) {
                return mid;
            }else {
                low=mid;
            }
        }
        return high;
    }


    public static void main(String[] args) {
        var m=new ModifiedInsertionSort();
    }
}
