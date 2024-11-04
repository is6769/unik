package Algo.practice1;

import java.util.*;
import java.util.stream.Collectors;

public class BinarySearch4 {

    //идея примерно следующая, она не особо эффективна, но в рамках бинарного поиска как-то в голову ничего больше не приходит
    //берем суб массив от i+1 до конца сортируем его по возрастанию и ищем в нем первый элемент равный i-элементу,
    // тогда все что будет до него <i-элемента, и есть то что нужно найти


    //а можно сделать способом ниже


    public BinarySearch4() {
        var lst=new ArrayList<Integer>();
        lst.add(33);
        lst.add(17);
        lst.add(23);
        lst.add(99);
        lst.add(44);

        var ansLst=new ArrayList<Integer>();

        var mapOfNumbers=new HashMap<Integer,Integer>();
        for (int i = lst.size()-1; i >-1 ; i--) {
            var key=lst.get(i);
            var keysThatAreSmaller=mapOfNumbers.keySet().stream().filter(k->k<key).collect(Collectors.toSet());
            var sumOfkeysThatAreSmaller=0;
            for(Integer skey:keysThatAreSmaller){
                sumOfkeysThatAreSmaller+=mapOfNumbers.get(skey);
                System.out.println();
            }
            ansLst.add(sumOfkeysThatAreSmaller);
            if (mapOfNumbers.containsKey(key)){
                mapOfNumbers.replace(key,mapOfNumbers.get(key)+1);
            }else{
                mapOfNumbers.put(key,1);
            }
        }

        Collections.reverse(ansLst);
        System.out.println(ansLst);
    }

    public static void main(String[] args) {
        var b=new BinarySearch4();
    }


}
