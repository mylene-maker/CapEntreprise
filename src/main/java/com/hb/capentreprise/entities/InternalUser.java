package com.hb.capentreprise.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class InternalUser {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(nullable = false)
	protected String pseudo;

	@Column(nullable = false)
	protected String password;
	
	@Column(nullable = false)
	protected String email;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	protected List<InternalRole> roles = new ArrayList<>();

	public InternalUser() {
		
	}
	
	public InternalUser(Long id, String pseudo, String password, String email) {
		super();
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<InternalRole> getRoles() {
		return roles;
	}

	public void setRoles(List<InternalRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "InternalUser [id=" + id + ", pseudo=" + pseudo + ", password=" + password + ", email=" + email + "]";
	}
	
	
	
}
