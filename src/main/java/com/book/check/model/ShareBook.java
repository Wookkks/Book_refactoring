package com.book.check.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
@Entity
public class ShareBook {

    public ShareBook() {
        this.shareYn = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String memo;

    @Column(nullable = false)
    private String area;

    @CreationTimestamp
    private Timestamp createDate;

    @Column(nullable = false)
    private Boolean shareYn;
}
