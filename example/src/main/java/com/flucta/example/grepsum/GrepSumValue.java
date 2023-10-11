package com.flucta.example.grepsum;

import com.flucta.core.common.Computable;

public class GrepSumValue implements Computable<Integer> {
    public int value;

    public GrepSumValue(int value) {
        this.value = value;
    }

    @Override
    public Integer add(Computable<Integer> computable) {
        return this.value + computable.getValue();
    }

    @Override
    public Integer minus(Computable<Integer> computable) {
        return this.value - computable.getValue();
    }

    @Override
    public Integer multiply(Computable<Integer> computable) {
        return this.value * computable.getValue();
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
