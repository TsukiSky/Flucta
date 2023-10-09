package com.flucta.example.bfs;

import com.flucta.core.graph.Graph;
import com.flucta.runtime.launcher.GraphProcessEnvironment;

public class bfs {
    public static void main(String[] args) {
        GraphProcessEnvironment env = GraphProcessEnvironment.getGraphProcessEnvironment();
        Graph graph = loadGraph();
        env.setGraph(graph);
        // TODO: set the starting task of GraphProcessing Environment
        env.execute();
    }

    private static Graph loadGraph() {
        // TODO: implement loadGraph method
        return null;
    }
}
