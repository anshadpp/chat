package com.example.demo.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chatId;
	
	@ManyToMany
	@JoinColumn(name="senderId" , referencedColumnName = "userId")
	private User senderId;
	
	@ManyToMany
	@JoinColumn(name="recieverId" , referencedColumnName = "userId")
	private User recieverId;
	
	@CreationTimestamp
    @Column(name = "messageTime", updatable = false)
    private LocalDateTime messageTIme;

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

	public User getRecieverId() {
		return recieverId;
	}

	public void setRecieverId(User recieverId) {
		this.recieverId = recieverId;
	}

	public LocalDateTime getMessageTIme() {
		return messageTIme;
	}

	public void setMessageTIme(LocalDateTime messageTIme) {
		this.messageTIme = messageTIme;
	}
	
}
