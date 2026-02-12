package presentation;

import aplication.UserService;
import domain.User;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final UserService userService;
    private final Scanner scanner;

    public ConsoleUI(UserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("КОМПЬЮТЕРНЫЙ КЛУБ 'GAMER'");

        while (true) {
            System.out.println("\nГЛАВНОЕ МЕНЮ:");
            System.out.println(" 1. Админ-панель (управление пользователями)");
            System.out.println(" 2. Выйти");
            System.out.print("\n👉 Выберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    adminMenu();
                    break;
                case "2":
                    System.out.println("\n👋 До свидания!");
                    return;
                default:
                    System.out.println("\n❌ Неверный выбор!");
            }
        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println("ПАНЕЛЬ АДМИНИСТРАТОРА");
            System.out.println("  1. Список пользователей");
            System.out.println("  2. Добавить пользователя");
            System.out.println("  3. Удалить пользователя");
            System.out.println("  4. Назад");
            System.out.print("\nВыберите действие: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showUsers();
                    break;
                case "2":
                    addUser();
                    break;
                case "3":
                    deleteUser();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("\n❌ Неверный выбор!");
            }
        }
    }

    private void showUsers() {
        List<User> users = userService.getAll();

        System.out.println("СПИСОК ПОЛЬЗОВАТЕЛЕЙ");
        System.out.println("ID   ИМЯ   БАЛАНС");

        for (User user : users) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getBalance());
        }

        pressEnterToContinue();
    }

    private void addUser() {
        System.out.print("ДОБАВЛЕНИЕ НОВОГО ПОЛЬЗОВАТЕЛЯ");

        try {
            System.out.print("Имя пользователя: ");
            String name = scanner.nextLine();

            System.out.print("Начальный баланс: ");
            double balance = Double.parseDouble(scanner.nextLine());

            userService.createUser(name,balance);

        } catch (NumberFormatException e) {
            System.out.println("\nОшибка: Введите корректное число");
        } catch (IllegalArgumentException e) {
            System.out.println("\nОшибка: " + e.getMessage());
        }

        pressEnterToContinue();
    }

    private void deleteUser() {
        System.out.print("УДАЛЕНИЕ ПОЛЬЗОВАТЕЛЯ");

        try {
            showUsers();

            System.out.print("\n🆔 ID пользователя для удаления: ");
            int userId = Integer.parseInt(scanner.nextLine());
            userService.deleteUser(userId);

        } catch (NumberFormatException e) {
            System.out.println("\n❌ Ошибка: Введите корректный ID");
        } catch (IllegalArgumentException e) {
            System.out.println("\n❌ Ошибка: " + e.getMessage());
        }

        pressEnterToContinue();
    }

    private void printHeader(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          " + title);
        System.out.println("=".repeat(60));
    }

    private void pressEnterToContinue() {
        System.out.print("\nНажмите Enter для продолжения...");
        scanner.nextLine();
    }
}