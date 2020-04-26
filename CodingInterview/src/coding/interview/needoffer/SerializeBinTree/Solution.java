package coding.interview.needoffer.SerializeBinTree;

import beans.TreeNode;
import utils.TreeUtils;

import java.util.*;

import static java.lang.System.out;

public class Solution {

    TreeNode buildTree(Integer[] seq){
        Queue<TreeNode > q = new LinkedList<>();
        TreeNode head = new TreeNode(seq[1]);
        int nodesNum = seq.length-1;
        q.offer(head);

        for(int i=1;i<=nodesNum/2;i++){
            TreeNode curr = q.poll();
            if(curr == null){
                q.offer(null);
                q.offer(null);
                continue;
            }

            if (seq[2*i] != null){
                curr.left = new TreeNode(seq[2*i]);
            }
            if (2*i+1 < seq.length && seq[2*i+1] != null){
                curr.right = new TreeNode(seq[2*i+1]);
            }
            q.offer(curr.left);
            q.offer(curr.right);
        }

        return head;
    }

    public String Serialize(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder builder = new StringBuilder();

        while (!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                builder.append("#");

            }else {
                builder.append(curr.val);
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        builder.append("!");
        return builder.toString();


    }

    TreeNode Deserialize(String str) {
        if(str.charAt(0) == '#'){
            return null;
        }else {
            Integer[] nodeVals = new Integer[str.length()];
            for(int i=0;i<str.length()-1;i++){
                if(str.charAt(i) == '#'){
                    nodeVals[i+1] = null;
                }else {
                    nodeVals[i+1] = Integer.parseInt(str.substring(i, i+1));
                }
                out.println(nodeVals[i+1]);
            }
            out.println();

            return buildTree(nodeVals);
        }

    }


    public static void main(String[] args) {
        // test method
        Solution s = new Solution();
        TreeNode node = s.Deserialize("55#55####6!");
        out.println(s.Serialize(node));



    }

}
