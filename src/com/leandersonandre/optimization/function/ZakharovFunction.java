package com.leandersonandre.optimization.function;

/**
 * Zakharov Function
 * f(x) = sum_{i=1}^n x_i^2 + ( sum_{i=1}^n 0.5*i*x_i )^2 + ( sum_{i=1}^n 0.5*i*x_i )^4
 * Domain assumed [-5, 10] for each variable
 */
public class ZakharovFunction implements Function {

    private final static double MIN_VALUE[] = {-5, -5, -5};
    private final static double MAX_VALUE[] = {10, 10, 10};

    @Override
    public double evaluate(double[] x) {
        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 0; i < x.length; i++) {
            sum1 += x[i] * x[i];
            sum2 += 0.5 * (i + 1) * x[i];
        }
        return sum1 + sum2 * sum2 + Math.pow(sum2, 4);
    }

    @Override
    public void validateAndFixDomain(double[] x) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] < MIN_VALUE[i]) {
                x[i] = MIN_VALUE[i];
            }
            if (x[i] > MAX_VALUE[i]) {
                x[i] = MAX_VALUE[i];
            }
        }
    }

    @Override
    public void generateRandomSolution(double[] solution) {
        for (int i = 0; i < solution.length; i++) {
            solution[i] = MIN_VALUE[i] + (MAX_VALUE[i] - MIN_VALUE[i]) * Math.random();
        }
    }
}
