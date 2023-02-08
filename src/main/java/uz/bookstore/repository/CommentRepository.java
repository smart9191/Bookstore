package uz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bookstore.entity.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}