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

    public int sumAllOperation(int c, int d, int e, int f) {
        return c + d + e + f;
    }

    public static void main(String[] args) {
        int result = sum(1);
        System.out.println(result);
        int result2 = minus(1);
        System.out.println(result2);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(1);
        System.out.println(rsl);
        Calculator calc = new Calculator();
        int rls = calc.divide(5);
        System.out.println(rls);
        Calculator sumAll = new Calculator();
        int slr = sumAll.sumAllOperation(result, result2, rsl, rls);
        System.out.println("Сумма значений всех операций: " + slr);
    }
}
