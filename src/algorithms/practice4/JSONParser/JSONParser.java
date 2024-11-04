package algorithms.practice4.JSONParser;

import java.util.Arrays;
import java.util.HashMap;

public class JSONParser {
    private String json;
    private HashMap<String,String> tokenizedJSON;
    private HashMap<String,Object> currentJSON=new HashMap<>();

    public JSONParser() {
    }

    public JSONParser(String json) {
        this.json = json;
    }

    private void parseJSON(){
        HashMap<String,Object> currentJSON2;
        String str;
        //var commacounter;
        Arrays.stream(json.substring(1,json.length()-1).split("")).forEach(ch->{
            //if ("{".equals(ch)) currentJSON.put()
            if ("\"".equals(ch)){

            }
        });
    }

}
