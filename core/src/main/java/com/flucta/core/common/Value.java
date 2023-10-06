package com.flucta.core.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Value<T> {
    private T value;
}
