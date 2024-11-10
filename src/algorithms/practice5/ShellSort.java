package algorithms.practice5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ShellSort {

    private int h=1;
    private ArrayList<Integer> lst;

    public ShellSort() {
        lst=new ArrayList<>(Arrays.asList(10,9,8,7,6,5,4,3,2,1));
        initH();
        shellSort(lst);
    }

    public ShellSort(ArrayList<Integer> lst) {
        this.lst = lst;
        initH();
    }

    private void shellSort(ArrayList<Integer> lst){
        if (h==1) {
            insertionSortOnIndexes(lst, IntStream.range(0,lst.size()).boxed().toList());
            System.out.println(lst);
            return;
        }
        for (int i = 0; i < h; i++) {
            var indexes=new ArrayList<Integer>();
            var n=0;
            var index=i;
            while (index < lst.size()){
                indexes.add(index);
                ++n;
                index=i+n*h;
            }
            insertionSortOnIndexes(lst,indexes);
        }
        h=(h-1)/3;
        shellSort(lst);
    }

    private  void insertionSortOnIndexes(ArrayList<Integer> lst, List<Integer> indexes){
        for (int i = 1; i < indexes.size(); i++) {
            var element=lst.get(indexes.get(i));
            var elementIndex=i;
            for (int j = i-1; j > -1; j--) {
                if (element<lst.get(indexes.get(j))) {
                    Collections.swap(lst, indexes.get(elementIndex), indexes.get(j));
                    elementIndex=j;
                }
            }
        }
    }

    private void initH() {
        var nextH=3*h+1;
        while (nextH<lst.size()/2){
            h=nextH;
            nextH=3*h+1;
        }
    }

    public static void main(String[] args) {
        var s = new ShellSort();
    }
}
