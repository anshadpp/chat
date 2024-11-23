package com.example.demo.models;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    // Changed from @ManyToMany to @ManyToOne
    @ManyToOne
    @JoinColumn(name = "senderId", referencedColumnName = "userId", nullable = false)
    private User senderId;

    @ManyToOne
    @JoinColumn(name = "receiverId", referencedColumnName = "userId", nullable = false)
    private User receiverId;

    @CreationTimestamp
    @Column(name = "messageTime", updatable = false)
    private LocalDateTime messageTime;

    // Getters and Setters
    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public User getSenderId() {
        return senderId;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
    }

    public User getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(User receiverId) {
        this.receiverId = receiverId;
    }

    public LocalDateTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDateTime messageTime) {
        this.messageTime = messageTime;
    }
}
