package com.example.demo.Comment.model;

import com.example.demo.Post.model.Post;
import com.example.demo.User.model.User;
import com.example.demo.Like.model.Like;
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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column()
    private  String content;

    @Column()
    private Boolean anonymous =Boolean.FALSE;

    @CreatedDate()
    private LocalDateTime createDate;

    @UpdateTimestamp()
    private  LocalDateTime updateDate;

    @Column()
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post Post;

    @OneToMany(mappedBy = "Like")
    private List<Like> Likes;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User User;
}
