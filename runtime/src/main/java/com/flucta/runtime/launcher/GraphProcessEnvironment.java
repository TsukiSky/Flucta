package com.flucta.runtime.launcher;

import com.flucta.core.engine.execution.ExecutionManager;
import com.flucta.core.graph.Graph;

/**
 * Running environment for graph processing
 */
public class GraphProcessEnvironment {
    Graph graph;
    ExecutionManager executionManager;
    int numThreads = 1;     // number of processing thread is set to 1 at the beginning

    public static GraphProcessEnvironment graphProcessEnv;

    private GraphProcessEnvironment() {
    }

    public static GraphProcessEnvironment getGraphProcessEnvironment() {
        if (graphProcessEnv == null) {
            graphProcessEnv = new GraphProcessEnvironment();
        }
        return graphProcessEnv;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public void execute() {
        this.executionManager = new ExecutionManager(this.graph, numThreads);
        this.executionManager.execute();
    }
}
