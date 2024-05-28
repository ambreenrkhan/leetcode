package leetCode.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeTraversal {
    public <T extends Integer> void depthFirstPreOrder(final TreeNode treeNode){
        if(Objects.nonNull(treeNode)){
            System.out.println("Pre Order traversing Node:" + treeNode.val);
            depthFirstPreOrder(treeNode.left);
            depthFirstPreOrder(treeNode.right);
        }
    }

    public <T extends Integer> void depthFirstInOrder(final TreeNode treeNode){
        if(Objects.nonNull(treeNode)){
            depthFirstInOrder(treeNode.left);
            System.out.println("In Order traversing dode:" + treeNode.val);
            depthFirstInOrder(treeNode.right);
        }
    }

    public <T extends Integer> void depthFirstPostOrder(final TreeNode treeNode){
        if(Objects.nonNull(treeNode)){
            depthFirstPostOrder(treeNode.left);
            depthFirstPostOrder(treeNode.right);
            System.out.println("Post Order traversing Node:" + treeNode.val);
        }
    }

    public <T extends Integer> void breadthFirstSearch(final TreeNode treeNode){
        Queue<TreeNode> queue = new LinkedList<>();
        if(Objects.nonNull(treeNode)){
            queue.add(treeNode);
        }

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println("Breadth First traversing Node:" + node.val);
            if(Objects.nonNull(node.left)){
                queue.add(node.left);
            }

            if(Objects.nonNull(node.right)){
                queue.add(node.right);
            }
        }
    }
}
