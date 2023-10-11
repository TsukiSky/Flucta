package com.flucta.core.common;

public interface Computable<T> {
    public T add(Computable<T> computable);
    public T minus(Computable<T> computable);
    public T multiply(Computable<T> computable);
    public T getValue();
}
