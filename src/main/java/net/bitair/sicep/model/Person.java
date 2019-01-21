package net.bitair.sicep.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =  true)
@SuppressWarnings("serial")
@Entity 

public class Person extends BaseModel{
	
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "persons")
	@Where(clause = "is_active = 1")
	private Set<School> schools; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    
    @Column(nullable = false)
	private String name;
	
    @Column(nullable = false)
	private String firstname;
	
    @Column(nullable = false)
	private String lastname;
	
    @Column(nullable = false)
	private String mail; 
	
    @Column(nullable = false)
	private long role;
    

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public long getRole() {
		return role;
	}

	public void setRole(long role) {
		this.role = role;
	}

	public Set<School> getSchools() {
		return schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}
	
	
	
}
