package Algo;

import java.util.ArrayList;

public class BinarySearch2 {

    public BinarySearch2() {
        var lst=new ArrayList<Integer>();
        lst.add(-1);lst.add(0);lst.add(-1);lst.add(-2);lst.add(-3);
        if(checkIfMountainArray(lst)){
            bsearch(lst);
        }else{
            System.out.println("Не горный массив");
        }
    }

    private boolean checkIfMountainArray(ArrayList<Integer> lst) {
        var m_index=-1;
        for (int i = 1; i < lst.size(); i++) {
            if (!(lst.get(i-1)<lst.get(i))){
                m_index=i-1;
                break;
            }
        }
        for (int i = m_index; i < lst.size()-1; i++) {
            if (!(lst.get(i)> lst.get(i+1))){
                return false;
            }
        }
        return true;
    }

    private void bsearch(ArrayList<Integer> lst){
        Integer midIndex=lst.size()/2;
        Integer st=0;
        Integer end=lst.size()-1;
        Integer midVal=lst.get(midIndex);

        while (st<=end){
            if (lst.get(midIndex-1)<midVal && midVal>lst.get(midIndex+1)){
                System.out.println("Индекс пика:"+midIndex);
                break;
            }
            else if (midVal<lst.get(midIndex+1)){
                st=midIndex+1;
            }else if (midVal>lst.get(midIndex+1)) {
                end=midIndex-1;
            }

            midIndex= Math.toIntExact(st + Math.round(((double) (end - st) / 2.0)));
            midVal=lst.get(midIndex);
        }
    }

    public static void main(String[] args) {
        var b= new BinarySearch2();
    }
}
