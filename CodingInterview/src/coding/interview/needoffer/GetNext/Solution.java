package coding.interview.needoffer.GetNext;

import java.util.*;

import static java.lang.System.out;

public class Solution {
    TreeLinkNode prev = null;

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // pNode 中序遍历的下一个节点一定在其左子树里
        if (pNode == null){
            return null;
        }
        if (pNode.right != null){
            TreeLinkNode next = getInOrderFirst(pNode);
            return next;
        }else {
            // pNode 右子树为空，
            // 若pNode为parent的左孩子，则中序遍历的下一个节点为父节点
            // 若pNode为parent的右孩子，则一直往上找
            // 直到找到一个节点不为其父节点的右孩子，那么这个节点的父节点就是中序遍历的下一个节点
            TreeLinkNode parent = pNode.next;
            if (parent == null){
                return null;
            }else {
                while (parent.next != null){
                    if (parent.next.left == parent){
                        return parent.next;
                    }else {
                        parent = parent.next;
                    }
                }
                // parent 为根节点了
                // 说明pNode已经是中序遍历序列的最后一个节点
                return null;
            }
        }

    }

    public TreeLinkNode getInOrderFirst(TreeLinkNode node){

        if(node == null || node.left == null){
            return node;
        }

        Stack<TreeLinkNode> stack = new Stack<>();

       TreeLinkNode curr = node;
        while(curr != null || !stack.isEmpty()){
            if (curr != null){
                stack.push(curr);
                curr = curr.next;
            }else {
                // 已经遍历到了最左子树的左孩子
                curr = stack.pop();
                return curr;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        // test method
    }

}
