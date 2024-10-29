package Algo;

import java.util.*;
import java.util.stream.Collectors;

public class EvklidAlgoV2 {
    public EvklidAlgoV2() {
        Scanner myObj = new Scanner(System.in);
        var lst=new ArrayList<Integer>();

        lst.add(myObj.nextInt());
        lst.add(myObj.nextInt());
        lst.add(myObj.nextInt());
        if (lst.stream().allMatch(x->x==0)){
            System.out.println("неопределено");
        }else {
            lst = new ArrayList<>(new HashSet<>(lst));

            if (lst.size() == 1) {
                System.out.println(Math.abs(lst.get(0)));
            } else if (lst.size() == 2) {
                System.out.println(findTNOD(lst));
            } else if (lst.size() == 3) {
                var nl = new ArrayList<Integer>();
                nl.add(findTNOD(new ArrayList<>(lst.subList(0, 2))));
                nl.add(lst.get(2));
                System.out.println(findTNOD(nl));
            }
        }
    }

    private int findTNOD(ArrayList<Integer> lst){

        lst= (ArrayList<Integer>) lst.stream().map(Math::abs).collect(Collectors.toList());

        if(lst.stream().anyMatch(x->x==0)){
            return lst.stream().reduce((x,y)->Math.abs(x+y)).get();
        }

        lst.sort(Integer::compareTo);

        try {
            while(lst.get(1)%lst.get(0)!=0){
                lst.sort(Integer::compareTo);
                lst.set(1,lst.get(1)%lst.get(0));
            }
        }catch (ArithmeticException e){
            return lst.get(1);
        }
        return lst.get(0);
    }

    public static void main(String[] args) {
        var evklidAlgo=new EvklidAlgoV2();
    }
}
