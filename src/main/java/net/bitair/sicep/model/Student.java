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

@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades de Json
@SuppressWarnings("serial") //
@Entity
public class Student extends BaseModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Se le da como primary key autoincrementable
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = true)
	private String lastName2;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "students") //Estudiante va a tenere relacio  Many to Many con escuelas, mapeada por students
	@Where(clause = "is_active = 1") //Escuela debe estar activa
	private Set<School> schools;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public Set<School> getSchools() {
		return schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}
	
	

}
