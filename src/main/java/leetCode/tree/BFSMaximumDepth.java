package leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSMaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int currentLevel = 1;
        int maximumLevel = 1;
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if (currentNode == null){
                if( currentLevel > maximumLevel){
                    maximumLevel = currentLevel;
                }
                if(!queue.isEmpty()) {
                    queue.add(null);
                    currentLevel++;
                }

            }else{
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BFSMaximumDepth BFSMaximumDepth = new BFSMaximumDepth();
        System.out.println(BFSMaximumDepth.maxDepth(null));
    }
}
