package com.fast2.test.java;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import one.util.streamex.EntryStream;

/**
 * {@link NameOccurences} is a class that show the stating statistics of names
 * 
 * @author Bassam Aldalati
 * @version 10/04/2017
 *
 */
public class NameOccurences {

	enum Parity {
		ODD, EVEN
	}

	/**
	 * This method is to return a map which contains names with even or odd occurrences depends on the input parameter
	 * @param name
	 * 			{@link List} of {@link String}  
	 * @param parity
	 * 			{@link Parity} is an enum, can be EVEN or ODD
	 * @return {@link Map}
	 * 				a {@link Map} of {@link String} filtered by {@link Parity}
	 * 			
	 */
	public static Map<String, Long> occurrencesWithChoice(List<String> name, Parity parity) {
		// get a map with name occurrences
		Map<String, Long> namesWithOccurences = occurrences(name);
		/*
		 * return a Map of even occurrences if the input parameter is
		 * EVEN,otherwise return a map with odd occurrences
		 */
		Map<String, Long> output = EntryStream.of(namesWithOccurences).mapValues(Long::valueOf)
				.filterValues(v -> (parity.equals(Parity.EVEN)) ? v % 2 == 0 : v % 2 != 0).toMap();
		return output;
	}


	private static Map<String, Long> occurrences(List<String> name) {
		/*
		 * calculate number of occurrences from a list then return a map with
		 * name as a key and occurrences number as a value
		 */
		Map<String, Long> occurences = name.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return occurences;
	}

	/**
	 * This method is to return a sorted {@link Map} based on the most frequently occuring names on the given list
	 * @param name
	 * 			is a {@link List} of {@link String}
	 * @return {@link Map}
	 * 		a sortedMap based the most frequently occuring names
	 */
	public static Map<String, Long> SortedOccurrences(List<String> name) {
		// get a map with name occurrences
		Map<String, Long> occurrences = occurrences(name);
		/*
		 * sort a map with name as a key and occurrences number as a value,
		 * based on the most  frequently occuring names
		 */
		Map<String, Long> sortedByOccurrences = occurrences.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> {
					throw new IllegalStateException();
				}, LinkedHashMap::new));
		return sortedByOccurrences;
	}
}
