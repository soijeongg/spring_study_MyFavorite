package com.example.demo.User.model;

import com.example.demo.Friend.model.Friend;
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
public class UserFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userFriendId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User User;

    @ManyToOne
    @JoinColumn(name = "FriendId")
    private Friend Friend;

    @CreatedDate()
    private LocalDateTime createDate;


    @Column()
    private LocalDateTime deletedAt;
}
