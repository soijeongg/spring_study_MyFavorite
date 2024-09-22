package com.example.demo.User.model;

import com.example.demo.Post.model.Post;
import com.example.demo.Comment.model.Comment;
import com.example.demo.Friend.model.FriendRequest;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = true)
    private  String email;

    @Column()
    private  String password;

    @Column()
    private  String username;

    @Column()
    private String profilePic;

    @Enumerated(EnumType.STRING)
    @Column()
    private  Role type = Role.MEMBER;

    @CreatedDate()
    private LocalDateTime createDate;

    @UpdateTimestamp()
    private  LocalDateTime updateDate;

    @Column()
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "comment",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "UserFavorite",cascade = CascadeType.ALL)
    private List<UserFavorite> userFavorites;

    @OneToMany(mappedBy = "Like",cascade = CascadeType.ALL)
    private List<Like> Likes;

    @OneToMany(mappedBy = "userFriend",cascade = CascadeType.ALL)
    private List<UserFriend> userFriends;

    @OneToMany(mappedBy = "requester",cascade = CascadeType.ALL)
    private List<FriendRequest> sentFriendRequests;

    @OneToMany(mappedBy = "recipient",cascade = CascadeType.ALL)
    private List<FriendRequest> receivedFriendRequests;

}
