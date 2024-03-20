package com.microservices.todoservices.todo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String description;
	private Date targetDate;
	private boolean status;
	
	
	public Todo(Long id, String username, String description, Date target, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = target;
		this.status = isDone;
	}
	
	protected Todo() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", target=" + targetDate + ", isDone="
				+ status + "]";
	}
	
	
}
