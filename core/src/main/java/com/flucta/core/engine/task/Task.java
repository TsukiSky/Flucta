package com.flucta.core.engine.task;

public abstract class Task implements Runnable {
    private final int id;

    Task(int taskId) {
        this.id = taskId;
    }
}
