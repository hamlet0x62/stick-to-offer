package coding.interview.tencent.compressString;

import java.util.*;

public class Solution {

    int findNextMatch(int start, String s){
        Stack<Character> stack = new Stack<>();

        for(int i=start;i<s.length();i++){
            if(s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                    if(stack.size() == 0){
                        return i;
                    }
                }else {
                    return -1;
                }
            }
        }

        return -1;
    }



    public String decode(String encodedText) {

        StringBuilder resultBuilder = new StringBuilder();

        for(int i=0;i<encodedText.length();i++){
            char curr = encodedText.charAt(i);
            if(curr == '['){
                int lastMatch = findNextMatch(i, encodedText);
                int divider = encodedText.indexOf('|', i);
                int num = Integer.valueOf(encodedText.substring(i+1, divider));

                String subPattern = decode(encodedText.substring(divider+1, lastMatch));

                for (int j=0;j<num;j++){
                    resultBuilder.append(subPattern);
                }
                i = lastMatch;
            }else {
                if(curr == ']' || curr == '|'){
                    return "Invalid String";
                }else {
                    resultBuilder.append(curr);
                }
            }
        }

        return resultBuilder.toString();


    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();


    }

}
