package uz.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter

public class UserActiveDto {

    @Id

    @Column(name = "user_name")
    private String username;

    @Column(name = "total_books_purchased")
    private Integer totalBooksPurchased;

    @Column(name = "total_purchase_amount")
    private Double totalPurchaseAmount;

    @Column(name = "total_comments")
    private Integer totalComments;

}
