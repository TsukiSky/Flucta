package com.flucta.core.graph;

import com.flucta.core.graph.vertex.Vertex;

import java.util.List;

public class Graph<T> extends VertexGroup<T> {
    public Graph(List<Vertex<T>> vertices) {
        super(vertices);
    }

    public boolean isAllVerticesInactive() {
        for (Vertex<T> vertex : this.getVertices()) {
            if (vertex.getState() == Vertex.VertexState.ACTIVE) {
                return false;
            }
        }
        return true;
    }
}
