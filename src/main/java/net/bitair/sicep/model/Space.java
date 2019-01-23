package net.bitair.sicep.model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;

public class Space {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@Where(clause = "is_active = 1")	
	private Set<CEscolar> CEscolar;
		
	private String acronym;
	private String namespace;
	private String name;
	private String role;
	private String user;
	private String password;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(nullable = false)
	public String getAcronym() {
		return acronym;
	}
	
	@Column(nullable = false)
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	@Column(nullable = false)
	public String getNamespace() {
		return namespace;
	}
	
	@Column(nullable = false)
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}
	
	@Column(nullable = false)
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable = false)
	public String getRole() {
		return role;
	}
	
	@Column(nullable = false)
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(nullable = false)
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
