package com.book.check.domain;

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
public class ShareBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "name")
    private User user;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String memo;

    @Column(nullable = false)
    private String area;

    @Column(nullable = false, length = 4)
    private String password;

    @CreationTimestamp
    private Timestamp createDate;

    @Column(nullable = false)
    private Boolean shareYn;

    public static class Builder {
        private Boolean shareYn = false;
        public Builder shareYn(Boolean shareYn) {
            this.shareYn = shareYn;
            return this;
        }
        public ShareBook build() {
            ShareBook shareBook = new ShareBook();
            shareBook.setShareYn(shareYn);
            return shareBook;
        }
    }
}
