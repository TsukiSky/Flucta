package com.flucta.core.common;

public interface Computable<T> {
    public T add(Computable<?> computable);
    public T minus(Computable<?> computable);
    public T multiply(Computable<?> computable);
}
