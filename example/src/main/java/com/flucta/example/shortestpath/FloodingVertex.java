package com.flucta.example.shortestpath;

import com.flucta.core.common.Computable;
import com.flucta.core.graph.vertex.Edge;
import com.flucta.core.graph.vertex.Message;
import com.flucta.core.graph.vertex.Vertex;

public class FloodingVertex extends Vertex<Double> {
    public FloodingVertex(int vertexId, Computable<Double> value) {
        super(vertexId, value);
    }

    @Override
    public void compute() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean updated = false;
        while (!this.getIncomingMessages().isEmpty()) {
            Computable<Double> incomingPathValue = this.getIncomingMessages().poll().getContent();
            if (incomingPathValue.getValue() < this.getComputable().getValue()) {
                updated = true;
                this.getComputable().setValue(incomingPathValue.getValue());
            }
        }

        if (updated) {
//            System.out.println("Vertex " + this.getId() + " updated value to " + this.getComputable().getValue());
            for (Edge<Double> edge : this.getOutgoingEdges()) {
                this.sendMessageAndWakeup(new Message<>(this.getComputable().add(edge.getValue())), edge.getTo());
            }
        }
        this.setState(VertexState.DOWN);
    }
}
