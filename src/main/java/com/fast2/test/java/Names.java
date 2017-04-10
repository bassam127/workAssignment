package com.fast2.test.java;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * {@link Names} is a class that contains {@link List} of {@link Name} as a field
 * 
 * @author Bassam Aldalati
 * @version 10/04/2017
 *
 */
public class Names {

	@SerializedName("names")
	private List<Name> names;

	/**
	 * Get a {@link List} of {@link Name}
	 * @return {@link List}
	 * 			List of {@link Name}
	 */
	public List<Name> getNames() {
		return names;
	}

	/**
	 * Set a {@link List} of {@link Name}
	 * @param names
	 * 			{@link List} of {@link Name}
	 */
	public void setNames(List<Name> names) {
		this.names = names;
	}

}
