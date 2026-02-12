package aplication;

import domain.User;
import infrastructure.InMemoryUserRepository;

import java.util.List;

public class UserServiceImpl implements UserService{

    private final InMemoryUserRepository userRepository;
    private int idCounter = 0;

    public UserServiceImpl(InMemoryUserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(String name, double balance) {
        if (name == null){
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if(balance < 0){
            throw new IllegalArgumentException("Баланс не может быть меньше нуля");
        }

        User user = new User(null,name,balance);
        idCounter += 1;
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(int userId) {
        return userRepository.delete(userId);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getUser(int userId) {
        return userRepository.getById(userId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Пользователь с ID %d не найден", userId)
                ));
    }

    @Override
    public User updateBalance(int userId, double newBalance) {
        User user = getUser(userId);
        user.setBalance(newBalance);
        return userRepository.update(user);
    }

}
