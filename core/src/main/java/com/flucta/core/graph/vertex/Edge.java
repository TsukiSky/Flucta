package com.flucta.core.graph.vertex;

import com.flucta.core.common.Computable;
import lombok.Data;

@Data
public class Edge {
    private Vertex from;
    private Vertex to;
    private Computable value;

    Edge(Vertex from, Vertex to, Computable value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}
