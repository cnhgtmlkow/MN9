package edu.ib;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;

public class Main10 {
    public static void main(String[] args) {
        Oscilator oscilator = new Oscilator(1.0);
        FirstOrderIntegrator euler = new EulerIntegrator(0.001);
        double [] x0 = {1,0};
        double [] x = new double[2];
        euler.integrate(oscilator,0,x0,Math.PI/2,x);
        System.out.println(x[0]+" "+x[1]);
    }
}
