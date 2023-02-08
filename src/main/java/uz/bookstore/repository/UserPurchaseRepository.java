package uz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bookstore.entity.UserPurchase;
@Repository
public interface UserPurchaseRepository extends JpaRepository<UserPurchase, Long> {
}