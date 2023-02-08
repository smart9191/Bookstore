package uz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bookstore.entity.Price;
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}