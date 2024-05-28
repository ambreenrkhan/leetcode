package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. Create a queue
 * 2. Push the root to the queue
 * 3. Pop from front and push kids to back
 * 4. Repeat until the queue is empty
 */
public class BinaryTreeBreadthFirstTraversal {
    public static void traverse(TreeNode root){
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null); // this is to mark the level
        int level = 0;
        StringBuilder sb = new StringBuilder();
        while(!nodes.isEmpty())        {
            TreeNode node = nodes.poll();
            
            if(node == null){
                level++; // you have reached end of level
                nodes.add(null);
                if(nodes.peek() == null) break; // two consecutive nulls so you have traversed the queue
            }else{
                sb.append("->").append(node.val).append("(").append(level).append(")");
                if(node.left!=null){
                    nodes.add(node.left);
                }
                if(node.right!=null){
                    nodes.add(node.right);
                }
            }
        }

        System.out.println(sb);
        System.out.println(level);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(7);
        // Level 2
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        // Level 3
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(11);
        root.right.right = new TreeNode(12);

        traverse(root);

    }
}
