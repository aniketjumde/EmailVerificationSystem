package com.auth.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login_attempts")
public class LoginAttempt 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", nullable = false, length = 150)
	private String email;
	
    @Column(name = "attempts")
	private Integer attempts=0;


	@Column(name = "last_attempt")
	private LocalDateTime lastAttempt;
	    
	@Column(name = "locked_until")
	private LocalDateTime lockedUntil;

	 
    // Constructors
    public LoginAttempt() {}
    
    public LoginAttempt(String email) {
        this.email = email;
        this.lastAttempt = LocalDateTime.now();
    }

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getAttempts() {
		return attempts;
	}


	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}


	public LocalDateTime getLastAttempt() {
		return lastAttempt;
	}


	public void setLastAttempt(LocalDateTime lastAttempt) {
		this.lastAttempt = lastAttempt;
	}


	public LocalDateTime getLockedUntil() {
		return lockedUntil;
	}


	public void setLockedUntil(LocalDateTime lockedUntil) {
		this.lockedUntil = lockedUntil;
	}


	
	
	
}
