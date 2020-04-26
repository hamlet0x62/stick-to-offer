package coding.interview.nextGreaterElement;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
        int[] result = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i], null);
        }

        for(int i=0;i<nums2.length;i++){

            if(stack.isEmpty() || stack.peek() < nums2[i]){
                while(!stack.isEmpty() && stack.peek() < nums2[i]){
                    int top = stack.pop();
                    map.put(top, i);
                    System.out.println(top);
                }
                if(map.containsKey(nums2[i]) && map.get(nums2[i]) == null){
                    stack.push(nums2[i]);
                }

            }else if(map.containsKey(nums2[i]) && map.get(nums2[i]) == null) {
                stack.push(nums2[i]);
            }
        }

        for(int i=0;i<nums1.length;i++){
            if(map.get(nums1[i]) != null){
                result[i] = map.get(nums1[i]);
            }else {
                result[i] = -1;
            }
        }

        return result;

    }


    public static void main(String[] args) {
        // test method

        Solution s = new Solution();
        Arrays.stream(s.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).forEach(out::print);



    }

}
