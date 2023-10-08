package com.flucta.core.engine.execution;

import com.flucta.core.engine.task.Task;
import com.flucta.core.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutionManager {
    Graph graph;
    private final Queue<Task> tasks;
    private final int numThreads;

    ExecutionManager(Graph graph, int numThreads) {
        this.graph = graph;
        this.tasks = new LinkedList<>();
        this.numThreads = numThreads;
    }

    public void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        while (!tasks.isEmpty()) {
            executorService.execute(tasks.poll());
        }
    }
}
