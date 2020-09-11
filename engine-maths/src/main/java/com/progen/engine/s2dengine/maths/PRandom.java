package com.progen.engine.s2dengine.maths;

public class PRandom {

    public static double NormalGauss(){
        return NormalGauss(0, 1);
    }

    public static double NormalGauss(double loc, double scale){
        double randomX = Math.random() - 0.5;
        double normalGauss = PFunctions.NormalGauss(randomX);
        return normalGauss * scale + loc;
    }

}
