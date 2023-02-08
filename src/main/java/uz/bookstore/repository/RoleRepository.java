package uz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bookstore.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}