package leetCode.tree;

import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * In BSTEach node has a maximum of up to two children.
 * For each node, the values of its left descendent nodes are less than that of the current node,
 * which in turn is less than the right descendent nodes (if any).
 */
public class BinaryTreeKthSmallestElement {

 public static int kthSmallest(TreeNode root, int k) {

    Stack<TreeNode> stack = new Stack<>();
    TreeNode currentNode = root;

    int toBeTraversed = k;
    while(!stack.isEmpty() || currentNode!=null){

     while(currentNode!=null){
      stack.push(currentNode);
      currentNode = currentNode.left;
     }

     currentNode = stack.pop();
     if(--toBeTraversed == 0){
      return currentNode.val;
     }

     currentNode = currentNode.right;
    }

    return 0;
 }


 //Input: root = [5,3,6,2,4,null,null,1], k = 3
 //Output: 3

 public static void main(String args[]){
    TreeNode root = new TreeNode(3);

     // Level 2
     root.left = new TreeNode(1);
     root.right = new TreeNode(4);

     // Level 3
     root.left.right = new TreeNode(2);

     kthSmallest(root, 1);
    }

}
