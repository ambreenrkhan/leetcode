package graph;

import java.util.*;

public class GraphTraversal<T> {

    public Set<Vertex<T>> depthFirstSearch(NonDirectionalGraph<T> graph, Vertex<T> root){
        Stack<Vertex<T>> stack = new Stack<>();
        Set<Vertex<T>> visited = new LinkedHashSet<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Vertex<T> vertexBeingVisited = stack.pop();

            if(!visited.contains(vertexBeingVisited)){
                visited.add(vertexBeingVisited);
                for(Vertex<T> adjVertex : graph.getAdjacentVertices(vertexBeingVisited)){
                    stack.push(adjVertex);
                }
            }
        }

        return visited;
    }


    public Set<Vertex<T>> breadthFirstSearch(NonDirectionalGraph<T> graph, Vertex<T> root){
        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visited = new LinkedHashSet<>();

        if(Objects.nonNull(root)){
            visited.add(root);
            queue.add(root);
        }

        while(!queue.isEmpty()){
            Vertex<T> vertexBeingVisited = queue.poll();

            for(Vertex<T> adjVertex : graph.getAdjacentVertices(vertexBeingVisited)){
                if(!visited.contains(adjVertex)){
                    visited.add(adjVertex);
                    queue.add(adjVertex);
                }
            }
        }

        return visited;
    }
}
