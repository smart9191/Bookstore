package uz.bookstore.service;

import org.springframework.stereotype.Service;
import uz.bookstore.entity.Role;
import uz.bookstore.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void init(){
        roleRepository.save(new Role("ROLE_ADMIN"));
        roleRepository.save(new Role("ROLE_USER"));
        roleRepository.save(new Role("ROLE_AUTHOR"));
    }
}
