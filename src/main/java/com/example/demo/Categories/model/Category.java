package com.example.demo.Categories.model;

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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false)
    private String categoryName;

    @CreatedDate()
    private LocalDateTime createDate;

    @UpdateTimestamp()
    private  LocalDateTime updateDate;

    @Column()
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<SubCategory> SubCategories;
}
