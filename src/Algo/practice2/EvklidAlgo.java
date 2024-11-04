package Algo.practice2;

import java.util.ArrayList;
import java.util.Scanner;

public class EvklidAlgo {

    public EvklidAlgo() {
        Scanner myObj = new Scanner(System.in);
        var lst=new ArrayList<Integer>();
        lst.add(myObj.nextInt());
        lst.add(myObj.nextInt());
        lst.add(myObj.nextInt());
        System.out.println(findNOD(lst));

    }

    private int findNOD(ArrayList<Integer> lst){
        int nod=-1;
        while(nod<0){
            lst.sort(Integer::compareTo);
            if (lst.get(1)%lst.get(0)==0 && lst.get(lst.size()-1)%lst.get(0)==0){
                nod=lst.get(0);
            }else{
                if (lst.get(lst.size()-1)%lst.get(0)==0){
                    lst.remove(2);
                }
                lst.set(lst.size()-1,lst.get(lst.size()-1)%lst.get(0));
            }
        }

        return nod;
    }

    public static void main(String[] args) {
        var evklidAlgo=new EvklidAlgo();
    }
}
