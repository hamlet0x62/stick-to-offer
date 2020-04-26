package coding.interview.calPoints;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public int calPoints(String[] ops) {
        int points = 0;
        Stack<Integer> stack = new Stack<>();

        if(ops == null || ops.length == 0){
            return points;
        }

        for(int i=0;i<ops.length;i++){
            if(stack.isEmpty() || ops[i].matches("-?\\d+")){
                int val = Integer.valueOf(ops[i]);
                points += val;
                stack.push(val);
            }else {
                if("+".equals(ops[i])){
                    int r1 = stack.pop();
                    int r2 = stack.peek();
                    points += (r1 + r2);
                    stack.push(r1);
                    stack.push(r1+r2);
                }else if("D".equals(ops[i])){
                    stack.push(stack.peek() * 2);
                    points += stack.peek();
                }else if("C".equals(ops[i])){
                    int cancelPoints = stack.pop();
                    points -= cancelPoints;
                }
            }
            System.out.println(points);
        }

        return points;

    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();
        out.println(s.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));

    }

}
