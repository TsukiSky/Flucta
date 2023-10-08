package com.flucta.core.engine.execution;

import com.flucta.core.engine.task.Task;
import com.flucta.core.graph.Graph;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutionManager {
    Graph graph;
    private final LinkedBlockingQueue<Task> tasks;
    private final int numThreads;

    ExecutionManager(Graph graph, int numThreads) {
        this.graph = graph;
        this.tasks = new LinkedBlockingQueue<>();
        this.numThreads = numThreads;
    }

    public void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        while (!tasks.isEmpty()) {
            executorService.execute(tasks.poll());
        }
    }
}
