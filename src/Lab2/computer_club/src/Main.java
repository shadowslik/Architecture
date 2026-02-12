import domain.User;
import domain.Computer;
import domain.UserRepository;
import domain.ComputerRepository;
import infrastructure.InMemoryUserRepository;
import infrastructure.InMemoryComputerRepository;
import aplication.UserService;
import aplication.UserServiceImpl;
import presentation.ConsoleUI;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        createTestData(userRepository);
        UserService userService = new UserServiceImpl((InMemoryUserRepository) userRepository);
        ConsoleUI ui = new ConsoleUI(userService);

        ui.run();
    }

    private static void createTestData(UserRepository userRepo) {
        // Создаем пользователей
        List<User> users = List.of(
                new User(null, "Иван Петров", 1000.0),
                new User(null, "Петр Сидоров", 500.0),
                new User(null, "Анна Иванова", 2500.0),
                new User(null, "Михаил Козлов", 750.0),
                new User(null, "Елена Смирнова", 1500.0)
        );

        for (User user : users) {
            userRepo.save(user);
        }
    }
}