package com.flucta.example.shortestpath;

import com.flucta.core.graph.Graph;
import com.flucta.core.graph.vertex.Message;
import com.flucta.core.graph.vertex.Vertex;
import com.flucta.runtime.launcher.GraphProcessEnvironment;

import java.util.Arrays;

public class FloodingRunner {
    private static Graph<Double> buildTestGraph() {
        Vertex<Double> vertex0 = new FloodingVertex(0, new FloodingValue(100000));
        Vertex<Double> vertex1 = new FloodingVertex(1, new FloodingValue(100000));
        Vertex<Double> vertex2 = new FloodingVertex(2, new FloodingValue(100000));

        vertex0.addNeighbor(vertex1, new FloodingValue(10));
        vertex1.addNeighbor(vertex2, new FloodingValue(20));

        return new Graph<>(Arrays.asList(vertex0, vertex1, vertex2));
    }

    public static void main(String[] args) {
        Graph<Double> graph = GraphLoader.loadGraph("example/src/main/java/com/flucta/example/shortestpath/GraphWidth-901.xlsx");
//        Graph<Double> graph = GraphLoader.loadGraph("example/src/main/java/com/flucta/example/shortestpath/Graph-901.xlsx");
        long startTime = System.nanoTime();
        GraphProcessEnvironment<Double> env = new GraphProcessEnvironment<>();
        env.setGraph(graph);
        env.addStartVertex(graph.getVertexById(0), new Message<>(new FloodingValue(0)));
        env.execute();
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) / 1000000 + " ms");
    }
}
