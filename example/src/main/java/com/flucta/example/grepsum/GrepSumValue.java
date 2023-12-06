package com.flucta.example.grepsum;

import com.flucta.core.common.Computable;

public class GrepSumValue implements Computable<Integer> {
    public int value;

    public GrepSumValue(int value) {
        this.value = value;
    }

    @Override
    public GrepSumValue add(Computable<Integer> computable) {
        return new GrepSumValue(this.value + computable.getValue());
    }

    @Override
    public GrepSumValue minus(Computable<Integer> computable) {
        return new GrepSumValue(this.value - computable.getValue());
    }

    @Override
    public GrepSumValue multiply(Computable<Integer> computable) {
        return new GrepSumValue(this.value * computable.getValue());
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
