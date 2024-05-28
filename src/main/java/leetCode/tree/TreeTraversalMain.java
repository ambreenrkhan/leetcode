package leetCode.tree;


public class TreeTraversalMain {


    private TreeNode createATree() {
        // Level 1
        TreeNode root = new TreeNode(1);

        // Level 2
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Level 3
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Level 4
        root.left.left.left = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);

        return root;
    }


    public static void main(String args[]){
        System.out.println("hello");

        TreeTraversalMain main = new TreeTraversalMain();
        TreeNode root = main.createATree();

        TreeTraversal traversal = new TreeTraversal();
        traversal.breadthFirstSearch(root);
        System.out.println("======================");
        traversal.depthFirstInOrder(root);
        System.out.println("======================");
        traversal.depthFirstPreOrder(root);
        System.out.println("======================");
        traversal.depthFirstPostOrder(root);
        System.out.println("======================");
    }
}
