package com.flucta.core.engine.task;

import com.flucta.core.engine.execution.ExecutionManager;
import com.flucta.core.graph.vertex.Vertex;

public class VertexTask extends Task {
    private final Vertex<?> vertex;

    public VertexTask(ExecutionManager executionManager, Vertex<?> vertex) {
        super(executionManager);
        this.vertex = vertex;
        this.vertex.setExecutionManager(executionManager);
    }

    @Override
    public void run() {
        vertex.compute();
    }
}
