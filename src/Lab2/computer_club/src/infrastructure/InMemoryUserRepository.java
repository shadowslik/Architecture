package infrastructure;

import domain.User;
import domain.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private Map<Integer,User> users = new HashMap<>();
    private Integer indexId = 1;
    @Override
    public Optional<User> getById(int userId) {
        return Optional.ofNullable(users.get(indexId));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User save(User user) {
        if (user.getId() == null){
            user.setId(indexId);
            indexId++;
        }
        users.put(user.getId(),user);
        return user;
    }

    @Override
    public boolean delete(int userId) {
        return users.remove(userId) != null;
    }

    @Override
    public User update(User user) {
        if(users.get(user.getId()) == null){
            throw new IllegalArgumentException("Такого пользователя не существует");
        }
        users.put(user.getId(),user);
        return user;
    }

}
