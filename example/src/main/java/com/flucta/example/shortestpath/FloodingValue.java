package com.flucta.example.shortestpath;

import com.flucta.core.common.Computable;

public class FloodingValue implements Computable<Double> {
    private double value;

    public FloodingValue(double value) {
        this.value = value;
    }

    @Override
    public Computable<Double> add(Computable<Double> computable) {
        return new FloodingValue(this.getValue() + computable.getValue());
    }

    @Override
    public FloodingValue minus(Computable<Double> computable) {
        return new FloodingValue(this.getValue() - computable.getValue());
    }

    @Override
    public FloodingValue multiply(Computable<Double> computable) {
        return new FloodingValue(this.getValue() * computable.getValue());
    }

    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public void setValue(Double value) {
        this.value = value;
    }
}
