package leetCode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 1.Create an empty stack to store nodes.
 * 2.Push the root node to the stack.
 * 3.Run a loop while the stack is not empty
 *      Pop the top node from stack.
 *      Print the popped node.
 *      Store all the children of popped node onto the stack. We must store children from right to left so that leftmost node is popped first.
 * 4.If stack is empty then we are done.
 */
public class NaryPreOrderTraversal {
    public static void traverse(Node root){

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            Node node = stack.pop();
            if (node != null) {
                sb.append("->").append(node.key);

                for(int i =node.child.size()-1; i>=0 ; i--){
                    stack.push(node.child.get(i)); // push starting frommright
                }
            }

        }

        System.out.println(sb);
    }

    private static class Node
    {
        char key;
        ArrayList<Node> child = new ArrayList<>();

        public Node(char key)
        {
            this.key = key;
        }
    }

    public static void main(String args[]){
        /*   Let us create below tree
         *            A
         *        /  / \  \
         *       B  F   D  E
         *      / \     |  /|\
         *     K  J     G C H I
         *    / \         |   |
         *   N   M        O   L
         */

        Node root = new Node('A');
        (root.child).add(new Node('B'));
        (root.child).add(new Node('F'));
        (root.child).add(new Node('D'));
        (root.child).add(new Node('E'));
        (root.child.get(0).child).add(new Node('K'));
        (root.child.get(0).child).add(new Node('J'));
        (root.child.get(2).child).add(new Node('G'));
        (root.child.get(3).child).add(new Node('C'));
        (root.child.get(3).child).add(new Node('H'));
        (root.child.get(3).child).add(new Node('I'));
        (root.child.get(0).child.get(0).child).add(new Node('N'));
        (root.child.get(0).child.get(0).child).add(new Node('M'));
        (root.child.get(3).child.get(0).child).add(new Node('O'));
        (root.child.get(3).child.get(2).child).add(new Node('L'));

        traverse(root);

        // should print A B K N M J F D G E C O H I L
    }
}
