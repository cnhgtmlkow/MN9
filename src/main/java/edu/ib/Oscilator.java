package edu.ib;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;

public class Oscilator implements FirstOrderDifferentialEquations {
    private double omega2;

    public Oscilator(double omega2) {
        this.omega2 = omega2;
    }

    @Override
    public int getDimension() {
        return 2;
    }

    @Override
    public void computeDerivatives(double t, double[] x, double[] xDot) throws MaxCountExceededException, DimensionMismatchException {
        xDot[0] = x[1];
        xDot[1] = x[0]*omega2;
    }
}
