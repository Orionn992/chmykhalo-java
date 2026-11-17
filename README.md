# Калькулятор на Java 21

Тестовое задание. Реализация класса Calculator на Java 21 с покрытием юнит-тестами на JUnit 5.

## Структура проекта
- `src/main/java/com/chmykhalo/Calculator.java` - класс с базовыми арифметическими операциями, проверкой деления на ноль, а также валидацией краевых значений (`NaN`, `Infinity`, переполнение `double`).
- `src/main/java/com/chmykhalo/Main.java` - последовательный вызов всех четырёх методов и вывод результатов в консоль.
- `src/test/java/com/chmykhalo/CalculatorTest.java` - позитивные и негативные юнит-тесты на JUnit 5.

## Запуск программы
```bash
mvn compile exec:java
```

## Запуск тестов
```bash
mvn test
```
