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
public class UserMonthDto {

    @Id

    @Column(name = "month")
    private String month;
    @Column(name = "total_users")
    private Integer totalUsers;

}
