package domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> getById(int userId);
    List<User> getAll();
    User save(User user);
    boolean delete(int userId);
    User update(User user);
}
