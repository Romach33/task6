package com.company.number2;

public class SumInfo {
    private final int count;
    private final double sum;

    SumInfo(double sum, int count) {
        this.sum = sum;
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    public double getSum() {
        return sum;
    }
}
