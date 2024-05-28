package leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSLeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes1 = getLeafNodes(root1);
        List<Integer> leafNodes2 = getLeafNodes(root2);

        return leafNodes1.equals(leafNodes2);
    }

    private List<Integer> getLeafNodes(TreeNode root){
        List<Integer> leafNodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        while(!stack.empty() || currentNode!=null){
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            TreeNode topNode = stack.pop();
            // print this
            if(topNode.left == null && topNode.right == null){
                leafNodes.add(topNode.val);
            }
            currentNode = topNode.right;
        }

        return leafNodes;
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        DFSLeafSimilarTrees st = new DFSLeafSimilarTrees();
        System.out.println(st.leafSimilar(root1,root2));
    }
}
