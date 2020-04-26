package coding.interview.needoffer.PrintBinTreeInSpecialOrder;

import java.lang.reflect.Array;
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

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        if(pRoot == null){
            return rst;
        }

        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        q.offer(pRoot);
        int level = 0;

        while(!q.isEmpty()){
            int currLevelQSize = q.size();
            ArrayList<Integer> nodesInThisLevel = new ArrayList<>();

            boolean useStack = level % 2 != 0;
            if(useStack) {
                for (int i = 0; i < currLevelQSize; i++) {
                    TreeNode curr = q.poll();
                    stack.push(curr);
                    if(curr.left != null){
                        q.offer(curr.left);
                    }
                    if (curr.right != null){
                        q.offer(curr.right);
                    }
                }
                while(!stack.isEmpty()){
                    nodesInThisLevel.add(stack.pop().val);
                }
            }else {
                for (int i = 0; i < currLevelQSize; i++) {
                    TreeNode curr = q.poll();
                    nodesInThisLevel.add(curr.val);
                    if(curr.left != null){
                        q.offer(curr.left);
                    }
                    if (curr.right != null){
                        q.offer(curr.right);
                    }
                }
            }
            rst.add(nodesInThisLevel);
            level++;


        }
        return rst;

    }


    public static void main(String[] args) {
        // test method
    }

}
