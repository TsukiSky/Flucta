package com.flucta.core.graph.vertex;

import com.flucta.core.common.Computable;
import lombok.Data;

@Data
public class Message<T> {
    private Computable<T> content;
    private MessageType type;

    public Message(Computable<T> content, MessageType type) {
        this.content = content;
        this.type = type;
    }

    public Message(Computable<T> content) {
        new Message<>(content, MessageType.NORMAL);
    }

    public enum MessageType {
        NORMAL, FUNCTIONAL
    }
}
