package com.flucta.core.engine.execution;

import com.flucta.core.engine.task.Task;
import com.flucta.core.graph.Graph;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutionManager {
    Graph<?> graph;
    private final LinkedBlockingQueue<Task> tasks;
    private final int numThreads;

    public ExecutionManager(Graph<?> graph, int numThreads) {
        this.graph = graph;
        this.tasks = new LinkedBlockingQueue<>();
        this.numThreads = numThreads;
    }

    public void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        while (true) {
            if (!tasks.isEmpty()) {
                executorService.execute(tasks.poll());
            } else if (graph.isAllVerticesInactive()) {
                executorService.shutdown();
                return;
            }
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
