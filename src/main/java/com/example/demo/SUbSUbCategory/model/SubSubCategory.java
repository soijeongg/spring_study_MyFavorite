package com.example.demo.SUbSUbCategory.model;

import com.example.demo.Favorite.model.Favorite;
import com.example.demo.subCategory.model.SubCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class SubSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long subSubCategoryId;

    @Column()
    private String subSubCategoryName;

    @CreatedDate()
    private LocalDateTime createDate;

    @UpdateTimestamp()
    private  LocalDateTime updateDate;

    @Column()
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "SubCategoryId")
    private SubCategory subCategory;

    @OneToMany(mappedBy = "Favorite", cascade = CascadeType.ALL)
    private List<Favorite> Favorites;
}
