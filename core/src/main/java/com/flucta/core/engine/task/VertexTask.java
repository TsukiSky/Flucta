package com.flucta.core.engine.task;

import com.flucta.core.graph.vertex.Vertex;

public class VertexTask extends Task {
    private final Vertex vertex;

    public VertexTask(int taskId, Vertex vertex) {
        super(taskId);
        this.vertex = vertex;
    }

    @Override
    public void run() {
        vertex.compute();
    }
}
