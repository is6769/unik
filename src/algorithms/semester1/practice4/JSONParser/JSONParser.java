package algorithms.semester1.practice4.JSONParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class JSONParser {

    Stack<HashMap<String,Object>> stack = new Stack<>();

    public JSONParser(){
        String json=getJSON(Paths.get("D:\\IntellijIDEA\\IdeaProjects\\unik\\src\\algorithms\\practice4\\JSONParser\\example.json"));
        parseJSON(json);
    }

    private String getJSON(Path path) {
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object parseJSON(String json){

        //var currentKey="";
        StringBuilder currentKey= new StringBuilder();
        StringBuilder currentValue= new StringBuilder();
        States state=States.START;
        ArrayList<Object> lst;
        for(String symbol : Arrays.stream(json.split("")).toList()){
            switch (state){
                case START->{
                    if(symbol.equals("{")){
                        state=States.OPENINGBRACE;
                        stack.push(new HashMap<>());
                    }
                }
                case OPENINGBRACE, COMMA ->{
                    if(symbol.equals("\"")){
                        state=States.OPENINGQUOTE;
                    }
                }
                case OPENINGQUOTE->{
                    if(symbol.equals("\\")){
                        state=States.ESCAPECHARACTER;
                    } else if (symbol.equals("\"")) {
                        state = States.CLOSINGQUOTE;
                    } else {
                        currentKey.append(symbol);
                    }
                }
                case CLOSINGQUOTE->{
                    if(symbol.equals(":")){
                        state=States.COLON;
                    }
                }
                case COLON -> {
                    if(symbol.equals("[")){
                        state=States.OPENINGBRACKET;
                        lst=new ArrayList<>();
                    }
                    else if(symbol.equals(",")) {
                        state = States.COMMA;
                        var map=stack.peek();
                        map.put(currentKey.toString(),currentValue.toString());
                        currentKey.setLength(0);
                        currentValue.setLength(0);
                    } else if (symbol.equals("}")) {
                        state=States.CLOSINGBRACE;
                        var map=stack.peek();
                        map.put(currentKey.toString(),currentValue.toString());
                        currentKey.setLength(0);
                        currentValue.setLength(0);
                    } else{
                        currentValue.append(symbol);
                    }
                }

                case OPENINGBRACKET -> {
                    if(symbol.equals("]")){
                        state=States.CLOSINGBRACKET;

                    }else if(symbol.equals(",")){

                    }
                }

                case CLOSINGBRACE->{
                    System.out.println(stack.peek().toString());
                    return "";
                }
            }

        }
        System.out.println(stack.peek().toString());



        return null;
    }

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
    }

}
