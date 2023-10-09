package com.flucta.core.graph.vertex;

import com.flucta.core.common.Context;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Vertex {
    private int id;
    private List<Edge> outgoingEdges;
    private List<Edge> incomingEdges;
    private VertexState state;

    public Vertex(int vertexId) {
        this.id = vertexId;
        this.outgoingEdges = new ArrayList<>();
        this.incomingEdges = new ArrayList<>();
        this.state = VertexState.ACTIVE;        // the initial state is set to ACTIVE by default
    }

    /**
     * Add an edge to this vertex
     */
    public void addEdge(Vertex toVertex) {
        for (Edge edge: outgoingEdges) {
            if (edge.getTo().getId() == toVertex.getId()) {
                // edge already exist
                return;
            }
        }
        Edge edge = new Edge(this, toVertex, null);
        outgoingEdges.add(edge);
        toVertex.incomingEdges.add(edge);
    }

    /**
     * Vertex compute
     */
    public abstract void compute(Context context);

    /**
     * The state of a Vertex
     * ACTIVE: not compute yet
     * DOWN: has computed
     */
    public enum VertexState {
        ACTIVE, DOWN
    }
}
