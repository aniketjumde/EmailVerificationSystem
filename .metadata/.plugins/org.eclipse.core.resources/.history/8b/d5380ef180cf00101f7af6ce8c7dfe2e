package com.auth.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="email_verification")
public class EmailVerification 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "user_id", nullable = false)
	 private User user;
	
	@Column(name = "token", nullable = false, length = 255)
	private String token;
	
	private LocalDateTime expiry;


    // Constructors
    public EmailVerification() {}
    
    public EmailVerification(User user, String token, LocalDateTime expiry) {
        this.user = user;
        this.token = token;
        this.expiry = expiry;
    }
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDateTime expiry) {
		this.expiry = expiry;
	}
	
	
}
