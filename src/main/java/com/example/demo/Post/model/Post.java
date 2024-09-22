package com.example.demo.Post.model;

import com.example.demo.Favorite.model.Favorite;
import com.example.demo.Comment.model.Comment;
import com.example.demo.Like.model.Like;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long postId;

    @Column()
    private String title;

    @Column()
    private  String imgurl;

    @Column()
    private Boolean anonymous =Boolean.FALSE;

    @Enumerated(EnumType.STRING)
    @Column()
    private  PostType type = PostType.normal;

    @ManyToOne
    @JoinColumn(name = "FavoriteId")
    private Favorite Favorite;

    @OneToMany(mappedBy = "LikeId", cascade = CascadeType.ALL)
    private List<Like> Likes;

    @OneToMany(mappedBy = "CommentId", cascade = CascadeType.ALL)
    private List<Comment> Comments;


}
