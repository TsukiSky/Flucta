package com.flucta.runtime.common;

import com.flucta.core.graph.Graph;

public abstract class Job {
    public Graph graph;
    Job(Graph graph) {
        this.graph = graph;
    }
}
