package com.flucta.core.graph.vertex;

import com.flucta.core.common.Computable;
import lombok.Data;

@Data
public class Edge<T> {
    private Vertex<T> from;
    private Vertex<T> to;
    private Computable<T> value;
//    private int value;

    Edge(Vertex<T> from, Vertex<T> to, Computable<T> value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}
