package uz.bookstore.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import uz.bookstore.service.RoleService;

@Service
public class DbInit implements CommandLineRunner {
    private final RoleService roleService;

    public DbInit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.init();
    }
}
