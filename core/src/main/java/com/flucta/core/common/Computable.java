package com.flucta.core.common;

public interface Computable<T> {
    public Computable<T> add(Computable<T> computable);
    public Computable<T> minus(Computable<T> computable);
    public Computable<T> multiply(Computable<T> computable);
    public T getValue();
    public void setValue(T value);
}
