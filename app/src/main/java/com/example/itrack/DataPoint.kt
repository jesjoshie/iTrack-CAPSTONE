package com.example.itrack

class DataPoint {
    var xValue = 0
    var yValue = 0

    constructor(xValue: Int, yValue: Int) {
        this.xValue = xValue
        this.yValue = yValue
    }

    fun getxValue(): Int {
        return xValue
    }

    fun getyValue(): Int {
        return yValue
    }
}