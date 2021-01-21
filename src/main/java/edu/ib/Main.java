package edu.ib;

import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator;
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator;
import org.apache.commons.math3.ode.nonstiff.MidpointIntegrator;


public class Main {
    public static void main(String[] args) {

        double h = 0.2;
        SimpleODE simple = new SimpleODE();
        FirstOrderIntegrator eulerIntegrator = new EulerIntegrator(h);
        FirstOrderIntegrator midPointIntegrator = new MidpointIntegrator(h);
        FirstOrderIntegrator rk4Integrator = new ClassicalRungeKuttaIntegrator(h);
        midPointIntegrator.addStepHandler(new ConsoleStepper());
        eulerIntegrator.addStepHandler(new ConsoleStepper());
        rk4Integrator.addStepHandler(new ConsoleStepper());
        double [] x0 = {2};
        double [] x = new double[1];
        double t0 = 0;
        double t = 4;

        double vrai = Math.exp(-0.5*t)*(-1.07692+3.07692*Math.exp(1.3*t));
        System.out.println(x[0]);
        System.out.println("Venerable Euler");
        eulerIntegrator.integrate(simple,t0,x0,t,x);

        double [] x1 = new double[1];
        System.out.println("Midpoint");
        midPointIntegrator.integrate(simple, t0,x0, t,x1);//75.37863036573665

        double [] x2 = new double[1];
        System.out.println("RK");
        rk4Integrator.integrate(simple, t0,x0,t,x2);


        System.out.println("Heune");
        double x01 = 2;
        x01 = heune(t0,t,h, x01);
        System.out.println("Bledy metod dla h = "+h+":");
        System.out.println("Eulera: "+blad(vrai, x[0])+" %");
        System.out.println("Eulera Ulepszonego: "+blad(vrai, x1[0])+" %");
        System.out.println("RK4: "+blad(vrai, x2[0])+" %");
        System.out.println("Heuna: "+blad(vrai, x01)+" %");

        System.out.println("Bledy metod dla h = "+h+":");
        System.out.println(blad(vrai, x[0]));
        System.out.println(blad(vrai, x1[0]));
        System.out.println(blad(vrai, x2[0]));
        System.out.println(blad(vrai, x01));





    }

    static double heune(double t0, double t, double h, double x0){
        double xi = 0;
        double nachylenie = 0;
        for (double i = t0; i<=t; i+=h){
            xi = x0+f(i, x0)*h;
            nachylenie = (f(i, x0)+f(i+h, xi))/2;
            x0 = x0+nachylenie*h;
            System.out.println(i+h+" "+x0);
        }
        return x0;
    }
    static double f(double t,double x){
        return 4*Math.exp(0.8*t)-0.5*x;
    }
    static double blad(double v, double x){
        return Math.abs(v-x)/v*100;
    }


}

