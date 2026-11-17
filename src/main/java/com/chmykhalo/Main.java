package com.chmykhalo;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double firstNumber = 10.0;
        double secondNumber = 2.0;

        System.out.println("Исходные числа: " + firstNumber + " и " + secondNumber);
        System.out.println("Сложение: " + calculator.add(firstNumber, secondNumber));
        System.out.println("Вычитание: " + calculator.subtract(firstNumber, secondNumber));
        System.out.println("Умножение: " + calculator.multiply(firstNumber, secondNumber));
        System.out.println("Деление: " + calculator.divide(firstNumber, secondNumber));
    }
}
