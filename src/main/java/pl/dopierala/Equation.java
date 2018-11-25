package pl.dopierala;

import java.util.Objects;

public class Equation{
    private double a;
    private double b;
    private double c;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation = (Equation) o;
        return  Double.compare(equation.a, a) == 0 &&
                Double.compare(equation.b, b) == 0 &&
                Double.compare(equation.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
