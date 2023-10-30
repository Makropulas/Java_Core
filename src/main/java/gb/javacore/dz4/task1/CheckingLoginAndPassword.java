package gb.javacore.dz4.task1;

import java.util.Scanner;

public class CheckingLoginAndPassword {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите логин: ");
                String login = scanner.nextLine();
                System.out.print("Введите пароль: ");
                String password = scanner.nextLine();
                System.out.print("Подтвердите пароль: ");
                String confirmPassword = scanner.nextLine();
                try {
                    if (passwordCheck(login, password, confirmPassword)) {
                        System.out.println("\nЛогин и пароль валидны");
                        break;
                    }
                } catch (WrongIdentificationException e) {
                    System.out.printf("\n%s. Введите данные заново\n\n", e.getMessage());
                }
            }
        }
    }

    /**
     * Метод проверки логина и пароля на соответствие условиям.
     *
     * @param login           Проверяемый логин.
     * @param password        Проверяемый пароль.
     * @param confirmPassword Проверяемый повторный пароль.
     * @return Подтверждение валидности пароля.
     * @throws WrongIdentificationException Если пароль не соответствует условиям.
     */
    static boolean passwordCheck(String login, String password, String confirmPassword) throws WrongIdentificationException {
        if (login.length() >= 20)
            throw new WrongLoginException("Логин слишком длинный. Должен быть меньше 20 символов");
        if (password.length() >= 20)
            throw new WrongPasswordException("Пароль слишком длинный. Должен быть меньше 20 символов");
        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("Пароли не совпадают");
        return true;
    }
}