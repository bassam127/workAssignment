package com.fast2.test.java;

import java.util.Comparator;

import com.fast2.test.java.SortedAndFilteredList.Order;

/**
 * This class is a list comparator, the comparator can be ASC or DESC
 * @author Bassam Aldalati
 * @version 10/04/2017
 *
 */
public class ListComparator {

	/**
	 * This method returns a comparator ASC or DESC depends on the input parameter
	 * @param order
	 * 			{@link Order} is an enum, can be ASC or DESC
	 * @return {@link Comparator}
	 */
	static Comparator<String> getAttributeComparator(Order order) {
		return new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// if ASC passed as parameter compare s1 to s2, otherwise
				// compare s2 to s1
				return (Order.ASC.equals(order)) ? s1.compareTo(s2) : s2.compareTo(s1);
			}
		};
	}
}
