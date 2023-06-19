package ru.job4j.ex;

import java.util.Objects;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User value : users) {
            if (Objects.equals(value.getUsername(), login)) {
                user = value;
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь невалидный");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {new User("Petr Arsentev", true)};
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("Этот пользователь имеет доступ");
            }
        } catch (UserInvalidException a) {
            a.printStackTrace();
        } catch (UserNotFoundException a) {
            a.printStackTrace();
        }
    }
}
