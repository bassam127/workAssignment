package com.fast2.test.java;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fast2.test.java.SortedAndFilteredList.Order;

public class ListComparatorTest {

	private List<String> names;

	@Before
	public void setUp() throws Exception {
		names = Arrays.asList("Bassam", "Johansson", "Lucas", "Ericsson", "Jakob", "Leif", "Annika", "Zlatan");
	}

	@Test
	public final void testSortedListAsc() {
		List<String> expected = Arrays.asList("Annika", "Bassam", "Ericsson", "Jakob", "Johansson", "Leif", "Lucas",
				"Zlatan");
		Comparator<String> AscComparator = ListComparator.getAttributeComparator(Order.ASC);
		Collections.sort(names, AscComparator);
		List<String> actual = names;
		assertThat(actual, is(expected));
	}

	@Test
	public final void testSortedListDesc() {
		List<String> expected = Arrays.asList("Zlatan", "Lucas", "Leif", "Johansson", "Jakob", "Ericsson", "Bassam",
				"Annika");
		Comparator<String> AscComparator = ListComparator.getAttributeComparator(Order.DESC);
		Collections.sort(names, AscComparator);
		List<String> actual = names;
		assertThat(actual, is(expected));
	}
}
