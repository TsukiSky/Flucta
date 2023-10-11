package com.flucta.core.graph.vertex;

import com.flucta.core.common.Computable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

@Data
public abstract class Vertex<T> {
    private int id;
    private List<Edge<T>> outgoingEdges;
    private List<Edge<T>> incomingEdges;
    private VertexState state;
    private Computable<T> value;
    private LinkedBlockingQueue<Message<T>> incomingMessages;

    public Vertex(int vertexId, Computable<T> value) {
        this.id = vertexId;
        this.outgoingEdges = new ArrayList<>();
        this.incomingEdges = new ArrayList<>();
        this.state = VertexState.ACTIVE;        // the initial state is set to ACTIVE by default
        this.incomingMessages = new LinkedBlockingQueue<>();
        this.value = value;
    }

    /**
     * Send a message to another vertex
     */
    public void sendMessage(Message<T> msg, Vertex<T> toVertex) {
        toVertex.incomingMessages.add(msg);
    }

    /**
     * Add an edge to this vertex
     */
    public void addEdge(Vertex<T> toVertex) {
        for (Edge<T> edge: outgoingEdges) {
            if (edge.getTo().getId() == toVertex.getId()) {
                // edge already exist
                return;
            }
        }
        Edge<T> edge = new Edge<>(this, toVertex, null);
        outgoingEdges.add(edge);
        toVertex.incomingEdges.add(edge);
    }

    /**
     * Vertex compute
     */
    public abstract void compute();

    /**
     * The state of a Vertex
     * ACTIVE: not compute yet
     * DOWN: has computed
     */
    public enum VertexState {
        ACTIVE, DOWN
    }

    public void addNeighbor(Vertex<T> vertex, Computable<T> value) {
        Edge<T> edge = new Edge<T>(this, vertex, value);
        this.outgoingEdges.add(edge);
        vertex.incomingEdges.add(edge);
    }

    public void addNeighbor(Vertex<T> vertex) {
        Edge<T> edge = new Edge<T>(this, vertex, null);
        this.outgoingEdges.add(edge);
        vertex.incomingEdges.add(edge);
    }
}
