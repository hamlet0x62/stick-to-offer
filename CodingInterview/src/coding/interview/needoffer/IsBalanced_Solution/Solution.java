package coding.interview.needoffer.IsBalanced_Solution;



public class Solution {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced(root) >= 0;
    }

    public int isBalanced(TreeNode node){
        if(node == null){
            return 0;
        }

        // 如果左右子树中有一子树不平衡，直接返回-1
        int leftDepth = isBalanced(node.left);
        if(leftDepth == -1){
            return -1;
        }
        int rightDepth = isBalanced(node.right);
        if(rightDepth == -1 || Math.abs(rightDepth-leftDepth) > 1){
            return -1;
        }else{
            // 返回当前子树的高度
            return Math.max(leftDepth, rightDepth) + 1;
        }

    }
}
