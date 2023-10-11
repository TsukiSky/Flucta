package com.flucta.example.grepsum;

import com.flucta.core.graph.Graph;
import com.flucta.core.graph.vertex.Vertex;
import com.flucta.runtime.launcher.GraphProcessEnvironment;

import java.util.Arrays;

public class GrepSum {
    public static void main(String[] args) {
        GraphProcessEnvironment env = GraphProcessEnvironment.getGraphProcessEnvironment();
        Graph<Integer> graph = loadGraph();
        env.setGraph(graph);
        env.addStartVertex(graph.getVertexById(0));
        env.execute();
    }

    private static Graph<Integer> loadGraph() {
        // TODO: implement loadGraph method
        return buildTestGraph();
    }

    private static Graph<Integer> buildTestGraph() {
        Vertex<Integer> vertex0 = new GrepSumVertex(0, new GrepSumValue(5));
        Vertex<Integer> vertex1 = new GrepSumVertex(1, new GrepSumValue(10));
        Vertex<Integer> vertex2 = new GrepSumVertex(2, new GrepSumValue(20));

        vertex0.addNeighbor(vertex1);
        vertex1.addNeighbor(vertex2);

        return new Graph<>(Arrays.asList(vertex0, vertex1, vertex2));
    }
}
