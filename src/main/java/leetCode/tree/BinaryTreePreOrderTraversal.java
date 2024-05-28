package leetCode.tree;

import java.util.Stack;

/**
 * Following is a simple stack based iterative process to print Preorder traversal.
 *
 * 1.Create an empty stack nodeStack and push root node to stack.
 * 2.Do the following while nodeStack is not empty.
 * 3.Pop an item from the stack and print it.
 *      Push right child of a popped item to stack
 *      Push left child of a popped item to stack
 *4.  The right child is pushed before the left child to make sure that the left subtree is processed first.
 */
public class BinaryTreePreOrderTraversal {
    public static void traverse(TreeNode rootNode){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            TreeNode node =stack.pop();
            sb.append("->").append(node.val);

            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }

        System.out.println(sb);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);

        // should print //10 8 3 5 2 2
        traverse(root);
    }
}
