package leetCode.graph;

import java.util.*;

public class NonDirectionalGraph<T> {
    // change this list to a map if we have a weight
    private Map<Vertex<T>, List<Vertex<T>>> vertices = new HashMap<>();

    public Vertex<T> addVertex(T value){
        Vertex<T> vertex = new Vertex<T>(value);
        vertices.putIfAbsent(new Vertex<T>(value), new ArrayList<>());
        return vertex;
    }

    public void addEdge(T value1, T value2){
        Vertex<T> vertex1 = addVertex(value1);
        Vertex<T> vertex2 = addVertex(value2);
        vertices.get(vertex1).add(vertex2);
        vertices.get(vertex2).add(vertex1);
    }

    public List<Vertex<T>> getAdjacentVertices(Vertex<T> vertex){
        return vertices.get(vertex);
    }
}
