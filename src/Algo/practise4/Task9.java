package Algo.practise4;

import java.util.Arrays;
import java.util.HashMap;

public class Task9 {

    public Task9() {
        makeHashMap("aabbbccccz");
    }

    private void makeHashMap(String str){
        HashMap<String,Integer> hashMap=new HashMap<>();
        Arrays.stream(str.split("")).forEach(x->{
            hashMap.computeIfPresent(x,(_,value)->++value);
            hashMap.computeIfAbsent(x, _ ->1);
            }
        );
        System.out.println(hashMap.toString());
    }

    public static void main(String[] args) {
        var t=new Task9();
    }
}