package com.flucta.core.graph;

import com.flucta.core.graph.vertex.Vertex;

import java.util.List;

public class Graph extends VertexGroup {
    public Graph(List<Vertex> vertices) {
        super();
        this.setVertices(vertices);
    }
}
