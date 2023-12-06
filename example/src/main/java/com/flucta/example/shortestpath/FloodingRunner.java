package com.flucta.example.shortestpath;

import com.flucta.core.graph.Graph;
import com.flucta.core.graph.vertex.Message;
import com.flucta.core.graph.vertex.Vertex;
import com.flucta.runtime.launcher.GraphProcessEnvironment;

import java.util.Arrays;

public class FloodingRunner {
    private static Graph<Integer> buildTestGraph() {
        Vertex<Integer> vertex0 = new FloodingVertex(0, new FloodingValue(100000));
        Vertex<Integer> vertex1 = new FloodingVertex(1, new FloodingValue(100000));
        Vertex<Integer> vertex2 = new FloodingVertex(2, new FloodingValue(100000));

        vertex0.addNeighbor(vertex1, new FloodingValue(10));
        vertex1.addNeighbor(vertex2, new FloodingValue(20));

        return new Graph<>(Arrays.asList(vertex0, vertex1, vertex2));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        GraphProcessEnvironment<Integer> env = new GraphProcessEnvironment<>();
        Graph<Integer> graph = buildTestGraph();
        env.setGraph(graph);
        env.addStartVertex(graph.getVertexById(0), new Message<>(new FloodingValue(0)));
        env.execute();
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) / 1000000 + " ms");
    }
}
