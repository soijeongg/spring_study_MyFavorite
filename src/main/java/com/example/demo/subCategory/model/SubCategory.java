package com.example.demo.subCategory.model;

import com.example.demo.Categories.model.Category;
import com.example.demo.SUbSUbCategory.model.SubSubCategory;
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
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subcategoryId;

    @Column()
    private String subCategoryName;

    @CreatedDate()
    private LocalDateTime createDate;

    @UpdateTimestamp()
    private  LocalDateTime updateDate;

    @Column()
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category Category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<SubSubCategory> subSubCategories;


}