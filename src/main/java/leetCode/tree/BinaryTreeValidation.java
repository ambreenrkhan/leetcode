package leetCode.tree;

import leetCode.tree.TreeNode;

import java.util.Stack;

/**
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class BinaryTreeValidation {
    public static boolean isValidBST(TreeNode root) {
        // traverse BST
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        Integer lastValue = null;
        while(!stack.isEmpty() || currentNode!=null){

            while(currentNode!=null){
                // keep pushing till we have traversed to teh left most node
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            // check right with current
            currentNode = stack.pop();
            if(  currentNode!=null  && lastValue!=null && currentNode.val<=lastValue){
                return false;
            }

            lastValue = currentNode.val;
            currentNode = currentNode.right;
        }

        return true;
    }


    public static void main(String args[]){
        TreeNode root = new TreeNode(5);

        // Level 2
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        // Level 3
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(isValidBST(root));
    }

}
