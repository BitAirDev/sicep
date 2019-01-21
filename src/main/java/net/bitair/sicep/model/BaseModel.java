/*
 * *******************************************************************************
 *   Copyright 2017 SICEP.
 * *******************************************************************************
 */
package net.bitair.sicep.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BaseModel implements Serializable {

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date dateCreated;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date dateUpdated;

	@Column(nullable = false, length = 50)
	private String dataOrigin;

	@Column(nullable = false)
	private String createdBy;

	@Column(nullable = false)
	private String updatedBy;

	@Column(nullable = false)
	private boolean isActive = true;

	@Version
	private Long version;

	public void clearValues() {
		dateCreated = null;
		dateUpdated = null;
		dataOrigin = null;
		createdBy = null;
		updatedBy = null;
	}

	@PreUpdate
	@PrePersist
	public void prePersistValues() {
		if (this.dateCreated == null) {
			this.dateCreated = new Date(System.currentTimeMillis());
		}

		this.dateUpdated = new Date(System.currentTimeMillis());

		if (this.dataOrigin == null) {
			this.dataOrigin = "GIC Engine";
		}
		if (this.createdBy == null) {
			this.createdBy = "GIC Engine";
		}
		if (this.updatedBy == null) {
			this.updatedBy = "GIC Engine";
		}
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the dateUpdated
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}

	/**
	 * @param dateUpdated
	 *            the dateUpdated to set
	 */
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	/**
	 * @return the dataOrigin
	 */
	public String getDataOrigin() {
		return dataOrigin;
	}

	/**
	 * @param dataOrigin
	 *            the dataOrigin to set
	 */
	public void setDataOrigin(String dataOrigin) {
		this.dataOrigin = dataOrigin;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
}
