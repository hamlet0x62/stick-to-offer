package coding.interview.countLessEqualThan;

import java.util.*;

import static java.lang.System.out;

class Solution {

    class SegTreeNode {
        SegTreeNode left;
        SegTreeNode right;
        int upper, lower;
        int count = 0;

        public SegTreeNode(int lower, int upper){
            this.lower = lower;
            this.upper = upper;
        }

        public boolean isIn(int num){
            return num >= lower && num <= upper;
        }
    }

    SegTreeNode buildSegTree(int min, int max){
        if(min > max){
            return null;
        }

        int mid = min + (max-min)/2;
        SegTreeNode root = new SegTreeNode(min, max);

        if(min == max){
            root.left = null;
            root.right = null;
        }else {
            root.left = buildSegTree(min, mid);
            root.right = buildSegTree(mid+1, max);
        }
        return root;

    }

    int countLessEqualThan(SegTreeNode root, int num){
        SegTreeNode curr = root;
        int count = 0;

        if(!curr.isIn(num)){
            return count;
        }else if(curr.upper == curr.lower){
            return curr.count;
        }else if(curr.count == 0){
            return 0;
        }

        if(curr.left != null && curr.left.isIn(num)){
            if(curr.left.upper == num){
                return curr.left.count;
            }else{
                return countLessEqualThan(curr.left, num);
            }
        }else {
            if (curr.left != null){
                count += curr.left.count;
            }
            return count + countLessEqualThan(curr.right, num);
        }
    }

    public List<Integer> countSmaller(int[] nums) {

        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }

        SegTreeNode root = buildSegTree(minVal, maxVal);
        List<Integer> result = new LinkedList<>();

        for(int i=nums.length-1;i>=0;i--){
            SegTreeNode curr = root;
            result.add(0, countLessEqualThan(curr, nums[i]));
            // update seg..tree
            while(curr != null && curr.isIn(nums[i])){
                curr.count += 1;
                if(curr.left != null && curr.left.isIn(nums[i])){
                    curr = curr.left;
                }else if(curr.right != null && curr.right.isIn(nums[i])){
                    curr = curr.right;
                }else {
                    curr = null;
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<Integer> result = s.countSmaller(new int[] {5, 2, 6, 1});
        result.stream().forEach(e -> {out.println(e);});
    }
}