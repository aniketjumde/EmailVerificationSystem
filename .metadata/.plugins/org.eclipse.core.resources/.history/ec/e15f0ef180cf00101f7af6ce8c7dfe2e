package com.auth.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User 
{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
    @Column(name = "name", nullable = false, length = 100)
	private String name;
	
    @Column(name = "email", nullable = false, unique = true, length = 150)
	private String email;
	
    @Column(name = "password", nullable = false, length = 255)
	private String password;
	
    @Column(name = "role", length = 30)
    private String role = "USER";
	
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 10)
    private UserStatus status = UserStatus.INACTIVE;

    public enum UserStatus {
        INACTIVE, ACTIVE
    }

	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;

	 public User() {
	        this.createdAt = LocalDateTime.now();
	    }

	public User(String name, String email, String password) 
	{
       
        this.name = name;
        this.email = email;
        this.password = password;
    }

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	
	
	

}
