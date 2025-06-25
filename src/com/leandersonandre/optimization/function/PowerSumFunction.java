package com.leandersonandre.optimization.function;

/**
 * Power Sum Function
 * f(x) = sum_{i=1}^n ( sum_{j=1}^n x_j^i )^2
 * Domain assumed [-10, 10] for each variable
 */
public class PowerSumFunction implements Function {

    private final static double MIN_VALUE[] = {-10, -10, -10};
    private final static double MAX_VALUE[] = {10, 10, 10};

    @Override
    public double evaluate(double[] x) {
        int n = x.length;
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            double innerSum = 0.0;
            for (int j = 0; j < n; j++) {
                innerSum += Math.pow(x[j], i);
            }
            sum += innerSum * innerSum;
        }
        return sum;
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
