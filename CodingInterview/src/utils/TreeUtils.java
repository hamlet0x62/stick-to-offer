package utils;

import beans.TreeNode;
import coding.interview.needoffer.isSymmetrical.Solution;

import static java.lang.System.out;

public class TreeUtils {

    public static void inOrder(TreeNode node){
        if (node == null){
            return ;
        }
        inOrder(node.left);
        out.print(node.val);
        inOrder(node.right);
    }
}
