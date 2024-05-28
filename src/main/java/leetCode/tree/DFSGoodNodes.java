package leetCode.tree;

import java.util.Stack;

public class DFSGoodNodes {
    public int goodNodes(TreeNode root) {
        int goodNodesCount = 0;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        TreeNode lastNode = null;
        StringBuilder pusher = new StringBuilder("Pushing ");
        StringBuilder popper = new StringBuilder("Popping ");
        int maximumNumberInBranch = root.val;
        boolean resetBranch = true;
        while(!stack.empty() || currentNode!=null){
            while (currentNode != null) {
                stack.push(currentNode);
                if(currentNode.val >= maximumNumberInBranch){
                    goodNodesCount++;
                }
                maximumNumberInBranch = Math.max(currentNode.val, maximumNumberInBranch);
                pusher.append("->").append(currentNode.val).append("(Reset ").append(resetBranch).append(" )");
                currentNode = currentNode.left;
                resetBranch = false;
            }

            TreeNode topNode = stack.pop();
            // now this is the new parent
            maximumNumberInBranch = Math.max(topNode.val, root.val);

            //       System.out.println("Popping " + topNode.val + ", Leaf="+(topNode.left == null && topNode.right == null));
            popper.append("->").append(topNode.val).append(" (LEFT ").append((topNode.left == null && topNode.right == null)).append(")");

            currentNode = topNode.right;
            resetBranch = true;
        }

        System.out.println(pusher.toString());
        System.out.println(popper.toString());

        return goodNodesCount;
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(4);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(3);
        root1.right.left.left = new TreeNode(5);
        root1.right.left.left.right = new TreeNode(5);
        root1.right.left.left.right.left = new TreeNode(4);
        root1.right.left.left.right.right = new TreeNode(4);

        DFSGoodNodes dfsGoodNodes = new DFSGoodNodes();
        System.out.println(dfsGoodNodes.goodNodes(root1));
    }
}
