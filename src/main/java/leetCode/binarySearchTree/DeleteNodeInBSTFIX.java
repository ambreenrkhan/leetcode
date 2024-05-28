package leetCode.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNodeInBSTFIX {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode parentNode = null;
        TreeNode currentNode = null;
        TreeNode nodeToBeDeleted = null;

        if(root.val == key){
            nodeToBeDeleted = root;
        }

        while(!queue.isEmpty()){
            currentNode = queue.poll();

            if(currentNode.left!=null && currentNode.left.val == key){
                parentNode = currentNode;
                nodeToBeDeleted = currentNode.left;
            }

            if(currentNode.right!=null && currentNode.right.val == key){
                parentNode = currentNode;
                nodeToBeDeleted = currentNode.right;
            }

            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }

            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }

        if(nodeToBeDeleted==null){
            return root;
        }

        if(nodeToBeDeleted.equals(root)){
            TreeNode newRoot = null;
            if(nodeToBeDeleted.left != null && nodeToBeDeleted.right != null){
                newRoot = currentNode;
                currentNode.left = root.left;
                currentNode.right = root.right;
            }
            else if(root.right!=null){
                newRoot = root.right;
                newRoot.left = root.left;
            }else{
                newRoot = root.left;
            }
            return newRoot;

        } else if(nodeToBeDeleted.left == null && nodeToBeDeleted.right == null){
            if(nodeToBeDeleted.equals(parentNode.right) ){
                parentNode.right = null;
            }else{
                parentNode.left = null;
            }
        }
        else if(nodeToBeDeleted.right!=null){
            parentNode.left = nodeToBeDeleted.right;
            parentNode.left.left = nodeToBeDeleted.left;
        }else{

            parentNode.left = nodeToBeDeleted.left;
        }

        return root;
    }

    public static void main(String[] args){
        DeleteNodeInBSTFIX deleteNodeInBST = new DeleteNodeInBSTFIX();

        TreeNode root = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        root.left = three;
        three.left = two;
        three.right = four;
        root.right = six;
        six.right = seven;

        System.out.println(deleteNodeInBST.deleteNode(root,7));
    }
}
