package Algo.practise4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public TwoSum() {
        System.out.println(twoSum(new int[]{3,2,4},6));
    }

    private int[] twoSum(int[] nums, int target){
        ArrayList<Integer> indexes=new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> hashMap=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            hashMap.computeIfPresent(nums[i],(_, value)->{
                value.add(finalI);
                return value;
            });
            hashMap.computeIfAbsent(nums[i], _ ->{
                var value=new ArrayList<Integer>();
                value.add(finalI);
                return value;
            });
        }
        hashMap.forEach((key, _)-> {
            if (hashMap.containsKey(target-key)){
                var smallerLength= Math.min(hashMap.get(key).size(), hashMap.get(target - key).size());
                if (target-key==key && hashMap.get(key).size()%2==1){
                    smallerLength--;
                }

                var indexLst=hashMap.get(target-key);
                for (int i = 0; i < smallerLength; i++) {
                    indexes.add(indexLst.get(i));
                }
            }
        });
        return indexes.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        var t = new TwoSum();
    }
}
