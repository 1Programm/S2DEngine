package com.progen.engine.s2dengine.maths;

public class PFunctions {

    private static final double PI_NORMAL = 1.0 / Math.sqrt(2.0 * Math.PI);
    private static final double HALF = 1.0 / 2.0;

    public static double NormalGauss(double x){
        return (Math.exp(-x * x * HALF) * PI_NORMAL);
    }

}
