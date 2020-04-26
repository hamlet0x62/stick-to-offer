package coding.interview.needoffer.ReverseSentence;

import java.util.*;

public class Solution {

    public String ReverseSentence(String str) {

        StringBuilder sbuilder = new StringBuilder();
        String[] words = str.split(" ");

        if(words.length == 1){
            if(" ".equals(words[0])){
                return "";
            } else {
                return words[0];
            }
        }

        for(int i=words.length-1;i>0;i--){
            sbuilder.append(words[i] + " ");
        }
        if(words.length > 0){
            sbuilder.append(words[0]);
        }

        return sbuilder.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String rst = solution.ReverseSentence("");
        System.out.print(rst.length());
    }

}
