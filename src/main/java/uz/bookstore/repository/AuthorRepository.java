package uz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bookstore.entity.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}