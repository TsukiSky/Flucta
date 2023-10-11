package com.flucta.example.grepsum;

import com.flucta.core.common.Computable;
import com.flucta.core.engine.task.VertexTask;
import com.flucta.core.graph.vertex.Edge;
import com.flucta.core.graph.vertex.Message;
import com.flucta.core.graph.vertex.Vertex;

public class GrepSumVertex extends Vertex<Integer> {
    public GrepSumVertex(int vertexId, Computable<Integer> value) {
        super(vertexId, value);
    }

    @Override
    public void compute() {
        Message<Integer> msg = this.getIncomingMessages().poll();
        while (msg != null) {
            this.getValue().add(msg.getContent());
            msg = this.getIncomingMessages().poll();
        }

        // send out messages
        for (Edge<Integer> edge :this.getOutgoingEdges()) {
            this.sendMessage(new Message<>(this.getValue()), edge.getTo());
            this.getExecutionManager().addTask(new VertexTask(this.getExecutionManager(), 0, edge.getTo()));
        }
        this.setState(VertexState.DOWN);
    }
}
