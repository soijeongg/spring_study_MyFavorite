package com.example.demo.Friend.model;

import com.example.demo.User.model.UserFriend;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long FriendId;

    @OneToMany(mappedBy = "UserFriends" )
    private List<UserFriend> UserFriends;

    @CreatedDate()
    private LocalDateTime createDate;

    @Column()
    private LocalDateTime deletedAt;


}
