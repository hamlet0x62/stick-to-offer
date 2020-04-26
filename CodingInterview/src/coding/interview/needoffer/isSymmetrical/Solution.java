package coding.interview.needoffer.isSymmetrical;

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

    public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) {
            return true;
        }
        TreeNode leftMirror = getMirror(pRoot.left);

        return isSame(leftMirror, pRoot.right);

    }

    TreeNode getMirror(TreeNode t){

        if(t == null){
            return null;
        }

        TreeNode left = t.left;
        TreeNode right = t.right;
        t.right = left;
        t.left = right;

        getMirror(t.left);
        getMirror(t.right);

        return t;

    }

    boolean isSame(TreeNode t1, TreeNode t2){
        if ((t1 == null && t2 != null) || (t2 == null && t1 != null)){
            return false;
        }else if(t1 == null && t2 == null){
            return true;
        }
        if (t1.val != t2.val){
            return false;
        }else {
            return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
        }
    }

    int getRealIndex(int i){
        return i-1;
    }

    TreeNode createTree(Integer[] seq){
        TreeNode head = new TreeNode(seq[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(head);

        for(int i=1;i<=seq.length/2;i++){
           TreeNode curr = q.poll();
           if (curr == null){
               continue;
           }
           Integer leftChild = seq[getRealIndex(2*i)];
           if (leftChild != null){
               curr.left = new TreeNode(leftChild);
           }
           q.offer(curr.left);
           int rightChildIndex = getRealIndex(2*i+1);
           if ( rightChildIndex < seq.length){
               if(seq[rightChildIndex] != null){
                   curr.right = new TreeNode(seq[rightChildIndex]);
               }
           }
           q.offer(curr.right);
        }

        return head;
    }

    static void inOrder(TreeNode node){
        if (node == null){
            return ;
        }
        inOrder(node.left);
        out.print(node.val);
        inOrder(node.right);
    }


    public static void main(String[] args) {
        // test method
        Solution s = new Solution();
        TreeNode node = s.createTree(new Integer[] {1});

        out.println(s.isSymmetrical(node));

    }

}
