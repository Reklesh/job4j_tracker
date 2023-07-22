package ru.job4j.bank;

import java.util.*;

/**
 * Класс разрабатывает модель для банковской системы.
 * @author Ivan Ivanov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами
     * осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию
     * с пустым списком счетов.
     * @param user пользователь, который добавляется в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход поле пользователя и удаляет пользователя из коллекции.
     * @param passport номер паспорта - поле пользователя.
     * @return возвращает true, если пользователь успешно удален.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает на вход поле пользователя и новый счет,
     * который добавляет к пользователю.
     * Пользователя нужно найти по паспорту, для этого используется метод findByPassport.
     * @param passport номер паспорта - поле пользователя.
     * @param account новый счет, который добавляется к пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта - поле пользователя.
     * @return возвращает пользователя или null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (Objects.equals(user.getPassport(), passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод принимает на вход поле пользователя и поле счета и ищет счет пользователя.
     * Пользователя нужно найти по паспорту, для этого используется метод findByPassport.
     * @param passport номер паспорта - поле пользователя.
     * @param requisite реквизиты - поле счета.
     * @return возвращает счет пользователя.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account account : list) {
                if (Objects.equals(account.getRequisite(), requisite)) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод принимает на вход: поле пользователя и поле счета для определения двух
     * счетов; деньги для перечисления с одного счёта на другой счёт.
     * Для определения счетов используется метод findByRequisite.
     * @param srcPassport номер паспорта - поле пользователя.
     * @param srcRequisite реквизиты - поле счета, с которого перечисляют деньги.
     * @param destPassport номер паспорта - поле пользователя.
     * @param destRequisite реквизиты - поле счета, на который перечисляют деньги.
     * @param amount деньги для перечисления.
     * @return возвращает true, если счёта найдены и достаточно денег на счёте, с которого переводят.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
