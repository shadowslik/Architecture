package domain;

import java.util.List;
import java.util.Optional;

public interface ComputerRepository {

    Optional<Computer> detById(int id);
    List<Computer> getAll();
    List<Computer> getAvailable();
    Computer save(Computer computer);
    Computer update(Computer computer);
}
