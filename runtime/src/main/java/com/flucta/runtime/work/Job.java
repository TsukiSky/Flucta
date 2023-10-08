package com.flucta.runtime.work;

import com.flucta.core.graph.Graph;

public abstract class Job {
    public Graph graph;
    Job(Graph graph) {
        this.graph = graph;
    }
}
