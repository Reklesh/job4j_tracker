package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int c) {
        return sum(c) + minus(c) + multiply(c) + divide(c);
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println(minus(10));
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(10);
        System.out.println(rsl);
        Calculator calc = new Calculator();
        int rls = calc.divide(10);
        System.out.println(rls);
        Calculator sumAll = new Calculator();
        int slr = sumAll.sumAllOperation(10);
        System.out.println("Сумма значений всех операций: " + slr);
    }
}
