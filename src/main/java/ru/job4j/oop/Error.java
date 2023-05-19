package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка " + active);
        System.out.println("Загружено " + status + "%");
        System.out.println("Памяти " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error computer = new Error(true, 50, "недостаточно");
        computer.printInfo();
        Error comp = new Error(false, 100, "достаточно");
        comp.printInfo();
    }
}
