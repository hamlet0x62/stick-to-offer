package coding.interview.removeOuterParentheses;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public String removeOuterParentheses(String S) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        String s = S;



        if (s == null || s.length() == 0){
            return "";
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(stack.size() == 1){
                    int lastMatch = stack.pop();
                    if(i-lastMatch > 1){
                        builder.append(s.substring(lastMatch+1, i));
                    }
                }else {
                    stack.pop();
                }
            }
        }

        return builder.toString();

    }


    public static void main(String[] args) {
        // test method

//        Solution s = new Solution();
//        out.println(s.removeOuterParentheses(""));

        out.println("-1".matches("-?\\d+"));

    }

}
