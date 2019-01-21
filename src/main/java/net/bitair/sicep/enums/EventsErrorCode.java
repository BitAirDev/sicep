/*
 * *******************************************************************************
 *   Copyright 2018.
 * *******************************************************************************
 */
package net.bitair.sicep.enums;

public enum EventsErrorCode {
	CZ_NOT_FOUND(001, "CZ_NOT_FOUND", "No se encuentra registro de CZ"),
	CZ_ACTIVE_EMPTY(002, "CZ_ACTIVE_EMPTY", "No hay CZ registrada");
	
	private int errorType;
	private String label;
	private String description;

	private EventsErrorCode(int errorType, String label, String description) {
		this.errorType = errorType;
		this.label = label;
		this.description = description;
	}

	public int getType() {
		return errorType;
	}

	public String getLabel() {
		return label;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
