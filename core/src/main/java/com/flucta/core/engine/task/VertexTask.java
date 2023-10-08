package com.flucta.core.engine.task;

import com.flucta.core.common.Context;
import com.flucta.core.graph.vertex.Vertex;

public class VertexTask extends Task {
    private final Vertex vertex;
    private final Context context;

    public VertexTask(int taskId, Vertex vertex, Context context) {
        super(taskId);
        this.vertex = vertex;
        this.context = context;
    }

    @Override
    public void run() {
        vertex.compute(context);
    }
}
