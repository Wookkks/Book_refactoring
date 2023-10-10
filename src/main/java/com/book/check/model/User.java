package com.book.check.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, unique = true)
    private String username;

    @Column(length = 100)
    private String password;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(length = 50)
    private String phoneNumber;

    @Column(length = 10)
    private String birth;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private String provider;
    
	private String providerId;
	
    @CreationTimestamp
    private Timestamp createDate;
}
