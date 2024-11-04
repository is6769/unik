package Algo.practice1;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch3 {

    public BinarySearch3() {
        var lst=new ArrayList<Integer>();
        for (int i = -16; i < 32; i++) {
            lst.add(i);
        }
        lst.removeAll(Collections.singleton(0));
        bsearch(0,lst);
    }

    //с помощью бинарного поиска можно найти индекс несуществующего элемента
    private void bsearch(Integer key,ArrayList<Integer> lst){
        Integer midIndex=lst.size()/2;
        Integer midVal=lst.get(midIndex);
        Integer st=-1;
        Integer end=lst.size();
        while (st<end){
            if (midVal<key){
                st=midIndex;
            }else{
                end=midIndex;
            }
            if (end-st==1){
                if (end >lst.size()- end){
                    System.out.println("Больше отрицательных:" + String.valueOf(end));
                }else if(end <lst.size()- end){
                    System.out.println("Больше положительных:"+String.valueOf(lst.size()- end));
                }else{
                    System.out.println("Поровну: "+String.valueOf(lst.size()- end));
                }
                return;
            }
            midIndex=st+(end-st)/2;
            midVal=lst.get(midIndex);
        }
    }

    public static void main(String[] args) {
        BinarySearch3 binarySearch3=new BinarySearch3();
    }
}
