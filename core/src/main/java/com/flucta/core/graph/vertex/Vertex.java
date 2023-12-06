package com.flucta.core.graph.vertex;

import com.flucta.core.common.Computable;
import com.flucta.core.engine.execution.ExecutionManager;
import com.flucta.core.engine.task.VertexTask;
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
    private Computable<T> computable;
    private LinkedBlockingQueue<Message<T>> incomingMessages;
    private ExecutionManager executionManager;

    public Vertex(int vertexId, Computable<T> computable) {
        this.id = vertexId;
        this.outgoingEdges = new ArrayList<>();
        this.incomingEdges = new ArrayList<>();
        this.state = VertexState.DOWN;        // the initial state is set to ACTIVE by default
        this.incomingMessages = new LinkedBlockingQueue<>();
        this.computable = computable;
    }

    /**
     * Send a message to another vertex
     */
    public void sendMessage(Message<T> msg, Vertex<T> toVertex) {
        toVertex.incomingMessages.add(msg);
    }

    public void sendMessageAndWakeup(Message<T> msg, Vertex<T> toVertex) {
        sendMessage(msg, toVertex);
        executionManager.addTask(new VertexTask(executionManager, toVertex));
        toVertex.setState(VertexState.ACTIVE);
    }

    /**
     * Add an edge to this vertex
     */
    public void addNeighbor(Vertex<T> toVertex, Computable<T> value) {
        for (Edge<T> edge: outgoingEdges) {
            if (edge.getTo().getId() == toVertex.getId()) {
                // edge already exist
                return;
            }
        }
        Edge<T> edge = new Edge<>(this, toVertex, value);
        outgoingEdges.add(edge);
        toVertex.incomingEdges.add(edge);
    }

    public void addNeighbor(Vertex<T> vertex) {
        this.addNeighbor(vertex, null);
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
}
