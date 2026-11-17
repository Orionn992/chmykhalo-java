package com.chmykhalo;

public class Calculator {

    public double add(double a, double b) {
        validateInputs(a, b);
        return validateResult(a + b);
    }

    public double subtract(double a, double b) {
        validateInputs(a, b);
        return validateResult(a - b);
    }

    public double multiply(double a, double b) {
        validateInputs(a, b);
        return validateResult(a * b);
    }

    public double divide(double a, double b) {
        validateInputs(a, b);
        if (b == 0.0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return validateResult(a / b);
    }

    private void validateInputs(double a, double b) {
        if (!Double.isFinite(a) || !Double.isFinite(b)) {
            throw new IllegalArgumentException("Аргументы должны быть конечными числами");
        }
    }

    private double validateResult(double result) {
        if (!Double.isFinite(result)) {
            throw new ArithmeticException("Результат выходит за пределы допустимых значений");
        }
        return result;
    }
}
