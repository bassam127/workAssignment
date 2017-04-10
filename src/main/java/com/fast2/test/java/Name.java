package com.fast2.test.java;

import com.google.gson.annotations.SerializedName;

/**
 * {@link Name} is a class that contains firstName and surName as fields
 * 
 * @author Bassam Aldalati
 * @version 10/04/2017
 *
 */
public class Name {

	enum NameType {
		FIRSTNAME, SURNAME
	}

	@SerializedName("firstname")
	private String firstName;
	@SerializedName("surname")
	private String surName;

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 *            is a firstName of type {@link String}
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get surName
	 * 
	 * @return surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * 
	 * @param surName
	 *            is a surName of type {@link String}
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/**
	 * Returns a string that "textually represents" this object
	 */
	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getSurName();
	}
}
