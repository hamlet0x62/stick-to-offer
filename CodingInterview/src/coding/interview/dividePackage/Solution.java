package coding.interview.dividePackage;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Solution {

    boolean betweenStartAndEnd(Integer[] seg, int start, int end){
        int segStart = seg[0], segEnd = seg[1];

        if(segEnd < start || segStart > end){
            return false;
        }else {
            return true;
        }
    }

    public ArrayList<Integer> divide(char[] sequence){

        if(sequence == null || sequence.length == 0){
            return new ArrayList<>(0);
        }

        HashMap<Character, Integer> map = new HashMap<>();

        Stack<Integer[]> stack = new Stack<>();

        for(int i=0;i<sequence.length;i++){
            if(!map.containsKey(sequence[i])){
                map.put(sequence[i], i);
                stack.push(new Integer[] {i, i});
            }else {
                int first = map.get(sequence[i]);
                while(!stack.isEmpty() && betweenStartAndEnd(stack.peek(), first, i)){
                    // 合并必须要合并的段
                    Integer[] seg = stack.pop();
                    if(first > seg[0]){
                        first = seg[0];
                    }
                }
                stack.push(new Integer[] {first, i});
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            Integer[] seg = stack.pop();
            result.add(0, seg[1]-seg[0]+1);
        }

        return result;


    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();

        String result = s.divide("MPMPCPMCMDEFEGDEHINHKLIN".toCharArray()).stream()
                .map(e -> e.toString()).collect(Collectors.joining(","));
        out.println(result);
    }

}
