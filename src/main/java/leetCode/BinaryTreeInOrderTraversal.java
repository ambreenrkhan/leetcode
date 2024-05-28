package leetCode;

import binaryTree.TreeNode;

import java.util.Stack;

/**
 * Remember that in order traversal, left->root->right,
 * 1.Create an empty stack (say S).
 * 2.Initialize the current node as root.
 * 3. Push the current node to S and set current = current->left until current is NULL
 *      If current is NULL and the stack is not empty then:
 *      Pop the top item from the stack.
 *      Print the popped item and set current = popped_item->right
 *      Go to step 3.
 * 4.If current is NULL and the stack is empty then we are done.
 *
 * It should print 4->2->5->1->3
 *             1
 *           /   \
 *         2      3
 *       /  \
 *     4     5
 */

public class BinaryTreeInOrderTraversal {
    public static void traverse(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> stack = new Stack<>();

        TreeNode<Integer> currentNode = root;

        StringBuilder sb = new StringBuilder();
        while(currentNode!=null || !stack.isEmpty()){

            while(currentNode!=null ){
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            currentNode = stack.pop();
            sb.append("->").append(currentNode);
            currentNode = currentNode.getRight();
        }


        System.out.println(sb);
    }



    public static void main(String args[]){
        TreeNode<Integer> root = new TreeNode(1);

        // Level 2
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Level 3
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        traverse(root);
    }
}
