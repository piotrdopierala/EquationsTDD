package pl.dopierala;

public class EquationSolver {
    public double solve(double a, double b, double c) {
        if(a==0)
            throw new IncorrectEquationException("Parameter a equal to zero.");
        return (c-b)/a;
    }


}
