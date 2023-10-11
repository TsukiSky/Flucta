package com.flucta.core.graph;

import com.flucta.core.graph.vertex.Vertex;
import lombok.Data;

import java.util.List;

@Data
public class VertexGroup<T> {
    private List<Vertex<T>> vertices;
    public VertexGroup(List<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    /**
     * Get vertex by vertex id
     */
    public Vertex<T> getVertexById(int vertexId) {
        for (Vertex<T> vertex: vertices) {
            if (vertex.getId() == vertexId) {
                return vertex;
            }
        }
        return null;
    }

    public void addVertex(Vertex<T> vertex) {
        this.vertices.add(vertex);
    }
}
