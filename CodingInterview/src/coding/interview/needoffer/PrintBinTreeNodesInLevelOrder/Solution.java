package coding.interview.needoffer.PrintBinTreeNodesInLevelOrder;

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

        if(pRoot == null) {
            return rst;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);

        while (!q.isEmpty()){
            int levelLength = q.size();
            ArrayList<Integer> nodes = new ArrayList<>();
            for(int i=0;i<levelLength;i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if (curr.right != null){
                    q.offer(curr.right);
                }
                nodes.add(curr.val);
            }
            rst.add(nodes);
        }

        return rst;

    }


    public static void main(String[] args) {
        // test method
    }

}
