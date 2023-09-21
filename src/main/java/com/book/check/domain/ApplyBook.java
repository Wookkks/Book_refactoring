package com.book.check.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ApplyBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "shareId")
    private ShareBook shareBook;

    @ManyToOne
    @JoinColumn(name = "name")
    private User user;

    @Column(nullable = false, length = 4)
    private String phoneNumber;




}
