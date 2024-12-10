package com.example.demo_api_custom_validation.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformers;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username",length = 50,nullable = false,unique = true)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "full_name",length = 50)
    private String fullName;
    @Column(name = "address")
    private String address;
    @Column(name = "email",length = 100,unique = true)
    private String email;
    @Column(name = "phone",length = 20,unique = true)
    private String phone;
}
