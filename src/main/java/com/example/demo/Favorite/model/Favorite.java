package com.example.demo.Favorite.model;

import com.example.demo.Post.model.Post;
import com.example.demo.SUbSUbCategory.model.SubSubCategory;
import com.example.demo.User.model.UserFavorite;
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
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long favoriteId;

    @Column()
    private String name;

    @Column()
    private  String description;

    @CreatedDate()
    private LocalDateTime createDate;

    @UpdateTimestamp()
    private  LocalDateTime updateDate;

    @Column()
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "SubSubCategoryId")
    private SubSubCategory SubSubCategory;

    @OneToMany(mappedBy = "UserFavorite", cascade = CascadeType.ALL)
    private List<UserFavorite> userFavorites;

    @OneToMany(mappedBy = "Post", cascade = CascadeType.ALL)
    private  List<Post> posts;
}
