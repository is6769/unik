package algorithms.semester1.practice5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sorting {

    public Sorting() {
        var list=new ArrayList<Integer>();
        var sc=Math.pow(10,-9);
        initTest(list);
        //modifiedInsertionSortV2(list);
        //System.out.println(list);
//        System.out.println(list);

        var l=getCopy(list);
        long startTime = System.nanoTime();
        //bubbleSort(l);
        //System.out.println(l);
        long estimatedTime = System.nanoTime() - startTime;
//        System.out.println("bubbleSort time elapsed: \t\t\t"+estimatedTime*sc);
//
//        l=getCopy(list);
//        startTime = System.nanoTime();
//
//        selectionSort(l);
//        //System.out.println(l);
//        estimatedTime = System.nanoTime() - startTime;
//        System.out.println("selectionSort time elapsed: \t\t"+estimatedTime*sc);
//
////
//        l=getCopy(list);
//        startTime = System.nanoTime();
//        insertionSort(l);
//        estimatedTime = System.nanoTime() - startTime;
//        System.out.println("insertionSort time elapsed: \t\t"+estimatedTime*sc);
////
////
//        l=getCopy(list);
//        startTime = System.nanoTime();
//        cocktailSort(l);
//        estimatedTime = System.nanoTime() - startTime;
//        System.out.println("cocktailSort time elapsed: \t\t\t"+estimatedTime*sc);
////
//        l=getCopy(list);
//        startTime = System.nanoTime();
//        shellSort(l,initH(1,l.size()/2));
//        //shellSort(l,9841);
//        estimatedTime = System.nanoTime() - startTime;
//        System.out.println("shellSort time elapsed: \t\t\t"+estimatedTime*sc);
////

        l=getCopy(list);
        startTime = System.nanoTime();
        quickSort(l,0,l.size());
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("quickSort time elapsed: \t\t\t"+estimatedTime*sc);
////
////
        l=getCopy(list);
        //System.out.println(l);
        startTime = System.nanoTime();
        modifiedInsertionSort(l);
        //System.out.println(l);
        estimatedTime = System.nanoTime() - startTime;
        //System.out.println(l);
        System.out.println("binaryInsertionSort time elapsed: \t"+estimatedTime*sc);

        l=getCopy(list);
        //System.out.println(l);
        startTime = System.nanoTime();
        modifiedInsertionSortV2(l);
        //System.out.println(l);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("binaryInsertionSortV2 time elapsed: \t\t"+estimatedTime*sc);


    }

    private ArrayList<Integer> getCopy(ArrayList<Integer> list) {
        return new ArrayList<>(list);
    }

    private void initTest(ArrayList<Integer> list) {
        for (int i = 0; i < 100000; i++) {
            list.add(ThreadLocalRandom.current().nextInt(1000));
        }
    }

    private void bubbleSort(ArrayList<Integer> list){
        var swaps=-1;
        while (swaps!=0){
            swaps = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    Collections.swap(list, i, i - 1);
                    swaps++;
                }
            }
        }
    }

    private void insertionSort(ArrayList<Integer> list){
        for (int i = 1; i < list.size(); i++) {
            var currentElement=list.get(i);
            var currentIndex=i;
            for (int j = i-1; j > -1; j--) {
                var changingElement=list.get(j);
                if (currentElement<changingElement){
                    Collections.swap(list,currentIndex,j);
                    currentIndex--;
                }else{
                    break;
                }
            }
        }
    }

    private void selectionSort(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            var min=Collections.min(list.subList(i,list.size()));
            list.remove(list.indexOf(min));
            list.add(i,min);
        }
    }

    public void cocktailSort(ArrayList<Integer> list){
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
        //System.out.println(list);
    }


    private void quickSort(List<Integer> lst, int low, int high) {
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

    private void shellSort(ArrayList<Integer> lst,int h){
        if (h==1) {
            insertionSort(lst);
            //System.out.println(lst);
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
        shellSort(lst,h);
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

    private int initH(int h,int s) {
        var nextH=3*h+1;
        while (nextH<s){
            h=nextH;
            nextH=3*h+1;
        }
        return h;
    }


    private void modifiedInsertionSortV2(ArrayList<Integer> lst) {
        //
        for (int i = 1; i < lst.size(); i++) {
            var index=binaryIndexSearch(lst,0,i);
            var swapIndex=i;
            var diff=i-index;
            while (diff>0){
                Collections.swap(lst,swapIndex,swapIndex-1);
                swapIndex--;
                diff--;
            }
        }
    }
    private void modifiedInsertionSort(ArrayList<Integer> lst) {
        for (int i = 1; i < lst.size(); i++) {
            lst.add(binaryIndexSearch(lst,0,i), lst.get(i));
            lst.remove(i+1);
        }
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
        var s=new Sorting();
    }
}

