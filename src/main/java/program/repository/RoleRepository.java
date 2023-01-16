package program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String role);
}
