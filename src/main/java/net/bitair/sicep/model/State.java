package net.bitair.sicep.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades de Json
@SuppressWarnings("serial") //
@Entity

public class State extends BaseModel{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Se le da como primary key autoincrementable
	private long id;
	
	@Column(nullable = false)
	private String name;//Estado
	
	@Column(nullable = false)
	private long townKey;//id Municipio
	
	@Column(nullable = false)
	private String town;//Municipio
	
	@Column(nullable = false)
	private String city;//Ciudad
	
	@Column(nullable = false)
	private String colonia;//Colonia
	 
	@Column(nullable = false)
	private long postalCode;//Codigo postal
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "states")
	@Where(clause = "is_active = 1")
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

	public long getTownKey() {
		return townKey;
	}

	public void setTownKey(long townKey) {
		this.townKey = townKey;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}

	public Set<School> getSchools() {
		return schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}
}
