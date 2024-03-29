package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class GetSubSequence {
    public static List<String> getSubSequence(String str){

        if(str.length() == 0){
            List<String> output = new ArrayList<>();
            output.add("");
            return output;
        }
        char ch = str.charAt(0);
        String resultantString = str.substring(1);

        List<String> result = getSubSequence(resultantString);
        List<String> finalOutput = new ArrayList<>();
        for(String item : result){
            finalOutput.add("" +item);
        }
        for(String item : result){
            finalOutput.add(ch + item);
        }

        return finalOutput;
    }


    public static void main(String[] args) {
        String str = "abcd";
        List<String> output = new ArrayList<>();
        output = getSubSequence(str);
        System.out.println(output);
    }
}
