package com.flucta.core.graph.vertex;

import com.flucta.core.common.Computable;

public class Message<T> {
    public Message(Computable<T> content, MessageType type) {
        this.content = content;
        this.type = type;
    }

    private Computable<T> content;
    private MessageType type;

    public enum MessageType {
        NORMAL, FUNCTIONAL
    }
}
