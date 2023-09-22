package com.book.check.model;

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

//    @OneToMany(mappedBy = "ApplyBook", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @JsonIgnoreProperties("{ApplyBook}")
//    @OrderBy("id desc")
//    private List<User> users;

    @Column(nullable = false, length = 4)
    private String phoneNumber;




}
