package binaryTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeTraversal {
    public <T extends Integer> void depthFirstPreOrder(final TreeNode<T> treeNode){
        if(Objects.nonNull(treeNode)){
            System.out.println("Pre Order traversing Node:" + treeNode.getValue());
            depthFirstPreOrder(treeNode.getLeft());
            depthFirstPreOrder(treeNode.getRight());
        }
    }

    public <T extends Integer> void depthFirstInOrder(final TreeNode<T> treeNode){
        if(Objects.nonNull(treeNode)){
            depthFirstInOrder(treeNode.getLeft());
            System.out.println("In Order traversing dode:" + treeNode.getValue());
            depthFirstInOrder(treeNode.getRight());
        }
    }

    public <T extends Integer> void depthFirstPostOrder(final TreeNode<T> treeNode){
        if(Objects.nonNull(treeNode)){
            depthFirstPostOrder(treeNode.getLeft());
            depthFirstPostOrder(treeNode.getRight());
            System.out.println("Post Order traversing Node:" + treeNode.getValue());
        }
    }

    public <T extends Integer> void breadthFirstSearch(final TreeNode<T> treeNode){
        Queue<TreeNode<T>> queue = new LinkedList<>();
        if(Objects.nonNull(treeNode)){
            queue.add(treeNode);
        }

        while(!queue.isEmpty()){
            TreeNode<T> node = queue.poll();
            System.out.println("Breadth First traversing Node:" + node.getValue());
            if(Objects.nonNull(node.getLeft())){
                queue.add(node.getLeft());
            }

            if(Objects.nonNull(node.getRight())){
                queue.add(node.getRight());
            }
        }
    }
}
