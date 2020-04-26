package coding.interview.binaryTreeIterator;

import java.util.*;

import static java.lang.System.out;

class BSTIterator {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    Stack<Integer> stack = new Stack<>();

    public BSTIterator(TreeNode root) {

        TreeNode curr = root;
        Stack<TreeNode> tmpStack = new Stack<>();
        while (curr != null || !stack.isEmpty()){
            if(curr != null){
                tmpStack.push(curr);
                curr = curr.right;
            }else {
                TreeNode top = tmpStack.pop();
                stack.push(top.val);
                curr = top.left;
            }
        }

    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop();

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
    }
}