package com.flucta.core.engine.task;

import com.flucta.core.engine.execution.ExecutionManager;
import lombok.Data;

@Data
public abstract class Task implements Runnable {
    private final ExecutionManager executionManager;

    Task(ExecutionManager executionManager) {
        this.executionManager = executionManager;
    }
}
