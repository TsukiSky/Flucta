package com.flucta.core.engine.task;

import com.flucta.core.engine.execution.ExecutionManager;
import lombok.Data;

@Data
public abstract class Task implements Runnable {
    private final int id;
    private final ExecutionManager executionManager;

    Task(ExecutionManager executionManager, int taskId) {
        this.executionManager = executionManager;
        this.id = taskId;
    }
}
