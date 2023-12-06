package com.flucta.runtime.launcher;

import com.flucta.core.engine.execution.ExecutionManager;
import com.flucta.core.engine.task.VertexTask;
import com.flucta.core.graph.Graph;
import com.flucta.core.graph.vertex.Message;
import com.flucta.core.graph.vertex.Vertex;
import com.flucta.runtime.Configuration;

/**
 * Running environment for graph processing
 */
public class GraphProcessEnvironment<T> {
    Graph<?> graph;
    ExecutionManager executionManager;
    int numThreads = 1;     // number of processing thread is set to 1 at the beginning


    public GraphProcessEnvironment() {
//        numThreads = Configuration.getCoreNumber();
    }

    public void setGraph(Graph<?> graph) {
        this.graph = graph;
    }

    public void execute() {
        if (this.executionManager == null) {
            this.executionManager = new ExecutionManager(this.graph, numThreads);
        }
        this.executionManager.execute();
    }

    public void addStartVertex(Vertex<T> vertex, Message<T> message) {
        // TODO: implement addStartVertex method
        if (this.executionManager == null) {
            this.executionManager = new ExecutionManager(this.graph, numThreads);
        }
        vertex.setState(Vertex.VertexState.ACTIVE);
        vertex.getIncomingMessages().add(message);
        this.executionManager.addTask(new VertexTask(this.executionManager, vertex));
    }
}
