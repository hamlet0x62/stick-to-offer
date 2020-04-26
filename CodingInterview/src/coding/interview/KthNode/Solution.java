package coding.interview.KthNode;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();

        if(pRoot == null || k < 1){
            return null;
        }

        TreeNode curr = pRoot;
        int count = 0;
        while(curr != null || stack.size()> 0){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else {
                curr = stack.pop();
                count++;
                if(count == k){
                    return curr;
                }else {
                    curr = curr.right;
                }
            }
        }

        return null;



    }


    public static void main(String[] args) {
        // test method
    }

}
