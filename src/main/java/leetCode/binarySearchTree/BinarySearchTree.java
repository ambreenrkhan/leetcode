package leetCode.binarySearchTree;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.val == val){
                return node;
            }

            if(node.left!=null){
                queue.add(node.left);
            }

            if(node.right!=null){
                queue.add(node.right);
            }
        }

        return null;
    }

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();

        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        root.left = two;
        root.right = seven;
        two.left = one;
        two.right = three;

        System.out.println(bst.searchBST(root,2));
    }

}
