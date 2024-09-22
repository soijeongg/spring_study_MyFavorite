package com.example.demo.Friend.model;

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
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long friendRequestId;

    @ManyToOne
    @JoinColumn(name = "requester")
    private User requester;

    @ManyToOne
    @JoinColumn(name = "recipient")
    private User recipient;

    @Enumerated(EnumType.STRING)
    private  FriendType FriendType = com.example.demo.Friend.model.FriendType.PENDING;

    @CreatedDate()
    private LocalDateTime createDate;

    @Column()
    private LocalDateTime deletedAt;
}
