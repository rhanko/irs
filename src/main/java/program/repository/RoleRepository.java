package program.repository;

import org.springframework.data.repository.CrudRepository;
import program.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(String role);
}
