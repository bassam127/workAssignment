package com.fast2.test.java;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
/**
 * This class allow to read from a JSON file
 * @author Bassam Aldalati
 * @version 10/04/2017
 *
 */
public class JSONReader {

	/**
	 * This method returns an object of {@link Names} which contains a list of {@link Name}
	 * @return names, is an object of {@link Names}
	 */
	public Names readFromJSON() {
		// Get the json file from ressources, and deserialize json into Names
		// object,which hold Name Object
		InputStream in = JSONReader.class.getResourceAsStream("/names.json");
		Names names = null;
		try {
			JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
			Gson gson = new Gson();
			names = gson.fromJson(reader, Names.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return names;
	}
}
