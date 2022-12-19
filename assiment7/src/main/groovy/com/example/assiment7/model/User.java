package com.example.assiment7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @NotNull(message= " can not null")
    @Id//P key
    private Integer id ;
    @NotEmpty(message= " can not empty")
    @Length(min = 4, message="Length more than 4")

    private String name;
    @NotEmpty(message= " can not empty")
    @Length(min = 4, message="Length more than 4")
    @Column(columnDefinition = "varchar(20)   unique")
    private String username;
    @NotNull(message= " can not null")

    private Integer password;
    @Email
    @NotEmpty(message= " can not empty")
    @Column(columnDefinition = "varchar(20)   unique")
    private String email;
    @Column(columnDefinition = "varchar(20)   check ( role (user, admin )")
private String role;
    @NotNull(message= " can not null")


    private Integer age;

}
