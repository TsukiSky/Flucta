package com.flucta.core.graph.vertex;

import lombok.Data;

import java.util.List;

@Data
public abstract class Vertex {
    private int id;
    private List<Edge> edges;

    /**
     * Add an edge to this vertex
     */
    public void addEdge(Vertex toVertex) {
        for (Edge edge: edges) {
            if (edge.getTo().getId() == toVertex.getId()) {
                return;
            }
        }
        edges.add(new Edge(this, toVertex, null));
    }
}
