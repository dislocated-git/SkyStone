package org.firstinspires.ftc.teamcode;

class CommonMethods {
    static double findMax(double... values) {
        double max = Double.NEGATIVE_INFINITY;

        for (double d : values) {
            if (d > max) max = d;
        }

        return max;
    }
}
