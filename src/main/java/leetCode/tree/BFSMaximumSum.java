package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSMaximumSum {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int maximumSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int currentLevel = 1;
        int maximumLevel = 1;
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if (currentNode == null){
                if( currentSum > maximumSum){
                    maximumSum = currentSum;
                    maximumLevel = currentLevel;
                }
                if(!queue.isEmpty()) {
                    queue.add(null);
                    currentLevel++;
                    currentSum = 0;
                }

            }else{
                currentSum += currentNode.val;

                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
        }

        return maximumLevel;
    }

    public static void main(String[] args){
        BFSMaximumSum bms = new BFSMaximumSum();
        TreeNode root = new TreeNode(-100);
        // Level 2
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-300);
        // Level 3
        root.left.left = new TreeNode(-20);
        root.left.right = new TreeNode(-5);
        root.right.left = new TreeNode(-10);

        System.out.println(bms.maxLevelSum(root));
    }
}

