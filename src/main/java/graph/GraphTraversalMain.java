package graph;

public class GraphTraversalMain {

    NonDirectionalGraph<String> createGraph() {
        NonDirectionalGraph<String> graph = new NonDirectionalGraph<>();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

    public static void main (String args[]){
        GraphTraversalMain main = new GraphTraversalMain();
        NonDirectionalGraph<String> graph = main.createGraph();

        GraphTraversal<String> traversal = new GraphTraversal<>();
        System.out.println(traversal.depthFirstSearch(graph, new Vertex<>("Bob")));
        System.out.println("===================");
        System.out.println(traversal.breadthFirstSearch(graph, new Vertex<>("Bob")));


    }
}
