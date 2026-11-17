package com.chmykhalo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private static final double DELTA = 0.0001;
    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void addPositiveNumbers() {
        assertEquals(15.0, calc.add(10.0, 5.0), DELTA);
    }

    @Test
    void addNegativeNumbers() {
        assertEquals(-8.0, calc.add(-5.0, -3.0), DELTA);
    }

    @Test
    void subtractPositiveNumbers() {
        assertEquals(6.0, calc.subtract(10.0, 4.0), DELTA);
    }

    @Test
    void subtractNegativeNumbers() {
        assertEquals(-2.0, calc.subtract(-5.0, -3.0), DELTA);
    }

    @Test
    void multiplyPositiveNumbers() {
        assertEquals(42.0, calc.multiply(6.0, 7.0), DELTA);
    }

    @Test
    void multiplyByZero() {
        assertEquals(0.0, calc.multiply(15.5, 0.0), DELTA);
    }

    @Test
    void dividePositiveNumbers() {
        assertEquals(5.0, calc.divide(20.0, 4.0), DELTA);
    }

    @Test
    void divideWithFractionalResult() {
        assertEquals(2.5, calc.divide(5.0, 2.0), DELTA);
    }

    @Test
    void divideZeroByNumber() {
        assertEquals(0.0, calc.divide(0.0, 5.0), DELTA);
    }

    @Test
    void divideByNegativeNumber() {
        assertEquals(-4.0, calc.divide(20.0, -5.0), DELTA);
    }

    @Test
    void divideByZeroThrowsException() {
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calc.divide(10.0, 0.0));
        assertEquals("Деление на ноль невозможно", ex.getMessage());
    }

    @Test
    void divideByNegativeZeroThrowsException() {
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calc.divide(10.0, -0.0));
        assertEquals("Деление на ноль невозможно", ex.getMessage());
    }

    @Test
    void nanInputThrowsException() {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> calc.add(Double.NaN, 5.0));
        assertEquals("Аргументы должны быть конечными числами", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> calc.add(5.0, Double.NaN));
        assertEquals("Аргументы должны быть конечными числами", ex2.getMessage());
    }

    @Test
    void infinityInputThrowsException() {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> calc.subtract(Double.POSITIVE_INFINITY, 1.0));
        assertEquals("Аргументы должны быть конечными числами", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> calc.multiply(2.0, Double.NEGATIVE_INFINITY));
        assertEquals("Аргументы должны быть конечными числами", ex2.getMessage());

        IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class, () -> calc.divide(Double.POSITIVE_INFINITY, 2.0));
        assertEquals("Аргументы должны быть конечными числами", ex3.getMessage());
    }

    @Test
    void overflowThrowsException() {
        ArithmeticException addEx = assertThrows(ArithmeticException.class, () -> calc.add(Double.MAX_VALUE, Double.MAX_VALUE));
        assertEquals("Результат выходит за пределы допустимых значений", addEx.getMessage());

        ArithmeticException subEx = assertThrows(ArithmeticException.class, () -> calc.subtract(-Double.MAX_VALUE, Double.MAX_VALUE));
        assertEquals("Результат выходит за пределы допустимых значений", subEx.getMessage());

        ArithmeticException mulEx = assertThrows(ArithmeticException.class, () -> calc.multiply(Double.MAX_VALUE, 2.0));
        assertEquals("Результат выходит за пределы допустимых значений", mulEx.getMessage());

        ArithmeticException divEx = assertThrows(ArithmeticException.class, () -> calc.divide(Double.MAX_VALUE, 0.1));
        assertEquals("Результат выходит за пределы допустимых значений", divEx.getMessage());
    }
}
