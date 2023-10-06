package com.flucta.core.graph;

import com.flucta.core.graph.vertex.Vertex;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VertexGroup {
    private List<Vertex> vertices;

    public VertexGroup() {
        this.vertices = new ArrayList<>();
    }

    /**
     * Get vertex by vertex id
     */
    public Vertex getVertexById(int vertexId) {
        for (Vertex vertex: vertices) {
            if (vertex.getId() == vertexId) {
                return vertex;
            }
        }
        return null;
    }
}
