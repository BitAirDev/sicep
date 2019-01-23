package net.bitair.sicep.model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;

public class Zona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@Where(clause = "is_active = 1")	
	private Set<Space> Space;
	
	private String Zone;
	private String Address;
	private String Assing;
	private Number PhoneNum;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public Set<Space> getSpace() {
		return Space;
	}
	
	@Column(nullable = false)
	public void setSpace(Set<Space> space) {
		Space = space;
	}
	
	@Column(nullable = false)
	public String getZone() {
		return Zone;
	}
	
	@Column(nullable = false)
	public void setZone(String zone) {
		Zone = zone;
	}
	
	@Column(nullable = false)
	public String getAddress() {
		return Address;
	}
	
	@Column(nullable = false)
	public void setAddress(String address) {
		Address = address;
	}
	
	@Column(nullable = false)
	public String getAssing() {
		return Assing;
	}
	
	@Column(nullable = false)
	public void setAssing(String assing) {
		Assing = assing;
	}
	
	@Column(nullable = false)
	public Number getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(Number phoneNum) {
		PhoneNum = phoneNum;
	}
}
