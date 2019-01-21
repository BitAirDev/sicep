package net.bitair.sicep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades de Json
@SuppressWarnings("serial") //
@Entity

public class prueba extends BaseModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Se le da como primary key autoincrementable
	private long id;
	
	@Column(nullable = false)
	private String materia;

	@Column(nullable = false)
	private long numMaterias;

	@Column(nullable = false)
	private int Calificaciones;

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public long getNumMaterias() {
		return numMaterias;
	}

	public void setNumMaterias(long numMaterias) {
		this.numMaterias = numMaterias;
	}

	public int getCalificaciones() {
		return Calificaciones;
	}

	public void setCalificaciones(int calificaciones) {
		Calificaciones = calificaciones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
