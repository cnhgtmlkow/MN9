package edu.ib;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

public class ConsoleStepper implements StepHandler {
    @Override
    public void init(double t0, double[] y0, double t) {
        System.out.println("Rozwiazanie");
        System.out.println(t0+" "+y0[0]);
    }

    @Override
    public void handleStep(StepInterpolator interpolator, boolean isLast) throws MaxCountExceededException {
        double t = interpolator.getCurrentTime();
        double [] x = interpolator.getInterpolatedState();
        System.out.println(t+ " "+x[0]);
    }


}