package com.example.demo.Like.model;

import com.example.demo.Comment.model.Comment;
import com.example.demo.Post.model.Post;
import com.example.demo.User.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long likeId;

    @ManyToOne
    @JoinColumn(name ="postId")
    private Post Post;

    @ManyToOne
    @JoinColumn(name = "CommentId")
    private Comment Comment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User User;

    @CreatedDate()
    private LocalDateTime createDate;

    @Column()
    private LocalDateTime deletedAt;

}
