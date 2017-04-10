package com.fast2.test.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import com.fast2.test.java.NameOccurences.Parity;

public class SortedAndFilteredList {

	enum Order {
		DESC, ASC
	}
	
	/**
	 * This method is to sort a {@link List}, filter the selection of names, and filter it based on the parity of 
	 * 			number of occurrences
	 * @param names
	 * 			{@link List} of {@link String} 
	 * @param comparator
	 * 				 {@link Comparator}
	 * @param parity
	 * 			{@link Parity} is an enum, can be EVEN or ODD
	 * @param predicate
	 * 				{@link Predicate}
	 * @param consumer
	 * 			{@link BiConsumer}
	 */
	public static void frequentSortedListWithSelectionAndFiltering(List<String> names, Comparator<String> comparator,
			Parity parity, Predicate<String> predicate, BiConsumer<String, Long> consumer) {
		// sort a collection based on the input comparator passed as a parameter
		Collections.sort(names, comparator);
		// get a map with name as a key and number of occurrences as a value, based on the parity
		Map<String, Long> nameOccurrences = NameOccurences.occurrencesWithChoice(names, parity);
		for (Map.Entry<String, Long> entry : nameOccurrences.entrySet()) {
			// true if the input argument matches the predicate, otherwise false
			if (predicate.test(entry.getKey())) {
				String name = entry.getKey();
				Long occurrences = entry.getValue();
				// Performs operation on the given arguments, if the predicate returns true.
				consumer.accept(name, occurrences);
			}
		}
	}
}
