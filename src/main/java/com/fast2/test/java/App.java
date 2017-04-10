package com.fast2.test.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.fast2.test.java.Name.NameType;
import com.fast2.test.java.NameOccurences.Parity;
import com.fast2.test.java.SortedAndFilteredList.Order;
/**
 * This class is the launcher of the whole program which contains the main method
 * @author Bassam Aldalati
 * @version 10/04/2017
 *
 */
public class App {
	private static List<String> firstNames;
	private static List<String> surNames;

	public static void main(String[] args) {
		JSONReader jsonReader = new JSONReader();
		// get the list of names from JSON
		Names names = jsonReader.readFromJSON();

		// fill firstNames list and surNames list
		fillNames(names);
		// print firstName and surName based on the
		// most frequently occurring names
		printSortedNamesByOccurences();

		/*
		 * print firstNames and surnames sorted, filtered by number of
		 * occurrences even or odd , and filtered with the letter of the name
		 */
		printFrequentSortedListWithSelectionAndFiltering(firstNames);
		printFrequentSortedListWithSelectionAndFiltering(surNames);

	}

	
	private static void fillNames(Names names) {
		// fill two separate lists, firstName, surName
		firstNames = fillNamesFromJsonByAGivingType(names, NameType.FIRSTNAME);
		surNames = fillNamesFromJsonByAGivingType(names, NameType.SURNAME);
	}

	//This method is called by fillNames, for getting the names from JSON file 
	private static List<String> fillNamesFromJsonByAGivingType(Names names, NameType nameType) {
		List<String> listOfNames = new ArrayList<>();
		/*
		 * return a list of names depends on the input parameter if SURNAME
		 * return surNames otherwise return firstNames
		 */
		for (Name name : names.getNames()) {
			listOfNames.add(nameType.equals(NameType.SURNAME) ? name.getSurName() : name.getFirstName());
		}
		return listOfNames;
	}

	
	private static void printSortedNamesByOccurences() {
		// print firstName and surName based on the
		// most frequently occuring names
		System.out.println(NameOccurences.SortedOccurrences(firstNames));
		System.out.println(NameOccurences.SortedOccurrences(surNames));
	}

	private static void printFrequentSortedListWithSelectionAndFiltering(List<String> names) {
		/*
		 * Choice, can be a world or a letter
		 * to be able to filter the selection  of names beginnig with choice
		 */
		String choice = "L";
		System.out.print("\nName is sorted on desc order, displaying only odd occurences, with names begining with "
				+ choice + "\n");
		// get a comparator, can be ASC or DESC
		Comparator<String> customComparator = ListComparator.getAttributeComparator(Order.DESC);
		SortedAndFilteredList.frequentSortedListWithSelectionAndFiltering(names, customComparator, Parity.ODD,
				// Predicate, name that start with choice
				(String name) -> name.startsWith(choice), (String name, Long occurrences) -> {
					// get name and occurrences if predicate is true.
					System.out.print(name + " " + occurrences + " ");
				});
	}

}
