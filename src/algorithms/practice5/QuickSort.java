package algorithms.practice5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class QuickSort {

    public QuickSort() {
        ArrayList<Integer> lst= new ArrayList<>(IntStream.generate(() -> new Random().nextInt(100)).limit(10).boxed().toList());
        System.out.println(lst);
        quickSort(lst,0,lst.size());
        System.out.println(lst);
    }

    private void quickSort(List<Integer> lst,int low,int high) {
        if (high-low<=1) {
            return;
        }
        var pivotIndex= high-1;
        var pivot=lst.get(pivotIndex);
        var tempIndex=part(lst,pivot,low,high);
        pivotIndex= (tempIndex==low) ? ++tempIndex : tempIndex;
        quickSort(lst,low,pivotIndex);
        quickSort(lst,pivotIndex,high);
    }

    private int part(List<Integer> lst, Integer pivot, int low, int high) {//60;67;435
        while (low<high) {
            if (lst.get(low)>pivot) {
                lst.add(high, lst.get(low));
                lst.remove(low);
                high--;
                low--;
            }
            low++;
        }
        return --high;
    }


    public static void main(String[] args) {
        var q =new QuickSort();
    }
}
