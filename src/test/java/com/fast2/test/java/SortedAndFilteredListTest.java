package com.fast2.test.java;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import com.fast2.test.java.NameOccurences.Parity;
import com.fast2.test.java.SortedAndFilteredList.Order;

public class SortedAndFilteredListTest {

	private List<String> names;
	private Map<String, Long> expected;

	@Before
	public void setUp() throws Exception {
		names = Arrays.asList("Lucas", "Leif", "Lucas", "Leif", "Annika", "Leif", "Annika", "Lucas");
	}

	@Test
	public final void testFrequentSortedListWithSelectionAndFilteringOddDesc() {
		String choice = "L";
		expected = new HashMap<String, Long>() {{put("Leif", 3L);put("Lucas",3L);}};
		Map<String, Long> actual = new HashMap<>();
		Comparator<String> customComparator = ListComparator.getAttributeComparator(Order.DESC);
		SortedAndFilteredList.frequentSortedListWithSelectionAndFiltering(names, customComparator, Parity.ODD,
				(String name) -> name.startsWith(choice), (String name, Long occurrences) -> {
					actual.put(name, occurrences);
				});
		assertThat(actual, is(expected));
	}
	
	@Test
	public final void testFrequentSortedListWithSelectionAndFilteringEvenAsc() {
		String choice = "A";
		expected = new HashMap<String, Long>() {{put("Annika",2L);}};
		Map<String, Long> actual = new HashMap<>();
		Comparator<String> customComparator = ListComparator.getAttributeComparator(Order.ASC);
		SortedAndFilteredList.frequentSortedListWithSelectionAndFiltering(names, customComparator, Parity.EVEN,
				(String name) -> name.startsWith(choice), (String name, Long occurrences) -> {
					actual.put(name, occurrences);
				});
		assertThat(actual, is(expected));
	}
}
