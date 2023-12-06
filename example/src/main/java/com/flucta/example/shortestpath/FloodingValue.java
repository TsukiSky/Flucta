package com.flucta.example.shortestpath;

import com.flucta.core.common.Computable;

public class FloodingValue implements Computable<Integer> {
    private int value;

    public FloodingValue(int value) {
        this.value = value;
    }

    @Override
    public Computable<Integer> add(Computable<Integer> computable) {
        return new FloodingValue(this.getValue() + computable.getValue());
    }

    @Override
    public FloodingValue minus(Computable<Integer> computable) {
        return new FloodingValue(this.getValue() - computable.getValue());
    }

    @Override
    public FloodingValue multiply(Computable<Integer> computable) {
        return new FloodingValue(this.getValue() * computable.getValue());
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
}
