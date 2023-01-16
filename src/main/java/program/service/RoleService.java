package program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.model.Role;
import program.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByName(String role) {
        return roleRepository.findByName(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
