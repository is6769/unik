package algorithms.practice1;

import java.util.ArrayList;

public class BinarySearch1 {

    public BinarySearch1() {
        var lst=new ArrayList<Integer>();
        for (int i = -16; i < 0; i++) {
            lst.add(i);
        }
        bsearch(-11,lst);
    }


    private void bsearch(Integer key, ArrayList<Integer> lst){
        Integer midIndex=lst.size()/2;
        Integer midVal=lst.get(midIndex);
        Integer st=-1;
        Integer end=lst.size();
        while (st<end){
            if (midVal==key){
                System.out.println(midIndex);
                return;
            }
            if (midVal<key){
                st=midIndex;
            }else{
                end=midIndex;
            }
            if (end-st==1){

                System.out.println("Элемент не сущесвует в массиве,его индекс был бы: "+end);

                return;
            }
            midIndex=st+(end-st)/2;
            midVal=lst.get(midIndex);
        }
    }

    public static void main(String[] args) {
        var b=new BinarySearch1();
    }

}
