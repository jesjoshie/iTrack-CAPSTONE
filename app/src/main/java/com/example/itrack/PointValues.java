package com.example.itrack;

public class PointValues {
    long xValue;
    double yValue;

    public PointValues() {
    }

    public PointValues(long xValue, double yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public long getxValue() {
        return xValue;
    }

    public double getyValue() {
        return yValue;
    }
}
