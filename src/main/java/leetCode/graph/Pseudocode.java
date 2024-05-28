package leetCode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pseudocode {
   public class Graph{
       public Node[] Nodes;
   }

    public class Node{
        public String name;
        public boolean visited;
        public Node[] adjacent;
    }

    public void searchDFS(Node root){
       if(root == null){
           return;
       }

       root.visited = true;
       for(Node n : root.adjacent){
           if(!n.visited ){
               searchDFS(n);
           }
       }
    }

    public void searchBFS(Node root){
        Queue<Node> nodeQueue = new LinkedList<>();

        root.visited = true;
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){
            Node current =nodeQueue.poll();
            //  now visit this current
            for(Node node : current.adjacent){
                if(!node.visited){
                    node.visited = true;
                    nodeQueue.add(node);
                }
            }
        }
    }
}
