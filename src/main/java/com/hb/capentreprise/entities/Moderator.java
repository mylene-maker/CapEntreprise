package com.hb.capentreprise.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Moderator extends InternalUser {
	
	@Column(nullable = false)
	private String phoneNumber;

	public Moderator() {
		
	}
	
	public Moderator(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Moderator [phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
