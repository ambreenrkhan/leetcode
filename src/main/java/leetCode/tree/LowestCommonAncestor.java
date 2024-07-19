package leetCode.tree;

import java.util.Objects;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversePostOrder(root, p, q);
    }

    private TreeNode traversePostOrder(TreeNode node, TreeNode p, TreeNode q){
        if(Objects.isNull(node) || node.equals(p) || node.equals(q)){
            return node;
        }

        TreeNode left = traversePostOrder(node.left, p, q);
        TreeNode right = traversePostOrder(node.right, p, q);

        if(Objects.nonNull(left) && Objects.nonNull(right)){
            return node;
        }

        return Objects.nonNull(left) ? left : right;
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode node = (TreeNode) o;
            return this.val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
  }

  public static void main(String[] args){
     TreeNode root = new TreeNode(3);
     root.left = new TreeNode(5);
     root.right = new TreeNode(1);
     root.left.left = new TreeNode(6);
     root.left.right = new TreeNode(2);
     root.right.left = new TreeNode(0);
     root.right.right = new TreeNode(8);
     root.left.right.left = new TreeNode(7);
     root.left.right.right = new TreeNode(4);

     var lca = new LowestCommonAncestor();
     System.out.println(lca.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)));
  }
}
