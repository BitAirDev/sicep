package net.bitair.sicep.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades de Json
@SuppressWarnings("serial") //
@Entity
public class School extends BaseModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY) //Estudiante va a tenere relacion  Many to Many con escuelas, mapeada por students
	@Where(clause = "is_active = 1") //Escuela debe estar activa	
	private Set<Student> students;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@Where(clause = "is_active = 1")
	private Set<Person> persons; 
	
	@OneToMany(fetch = FetchType.LAZY)
	@Where(clause = "is_active = 1")
	private Set<State> states;
	
	
	private String CCT;
	
	private int zona;
	
	private String direccion;
	
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public String getCCT() {
		return CCT;
	}

	public void setCCT(String cCT) {
		CCT = cCT;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
}
