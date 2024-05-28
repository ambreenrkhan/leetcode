package leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideResult = new ArrayList<>();
        if(root == null) return rightSideResult;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        TreeNode recentNotNullNode = root;
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode == null ){
                rightSideResult.add(recentNotNullNode.val);

                if(!queue.isEmpty()){
                    queue.add(null);
                }

            }else{
                recentNotNullNode = currentNode;

                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }

        }

        return rightSideResult;
    }

    public static void main(String[] args){
        BFSRightSideView bsv = new BFSRightSideView();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(bsv.rightSideView(root));
    }
}
