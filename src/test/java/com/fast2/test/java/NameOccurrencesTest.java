package com.fast2.test.java;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.fast2.test.java.NameOccurences.Parity;

public class NameOccurrencesTest {

	private List<String> input;

	@Before
	public void setUp() throws Exception {
		input = Arrays.asList("Marianne", "Klara", "Marianne", "Annn-Marie", "Marianne", "Klara", "Marianne", "Klara",
				"Håkan", "Håkan", "Klara", "Marianne", "Marianne");

	}

	@Test
	public final void testOccurencesWithChoiceEven() {
		Map<String, Long> expected = new HashMap<String, Long>() {
			{
				put("Marianne", 6L);
				put("Klara", 4L);
				put("Håkan", 2L);
			}
		};
		Map<String, Long> actual = NameOccurences.occurrencesWithChoice(input, Parity.EVEN);
		assertThat(actual, is(expected));
	}

	@Test
	public final void testOccurencesWithChoiceOdd() {
		Map<String, Long> expected = new HashMap<String, Long>() {
			{
				put("Annn-Marie", (long) 1);
			}
		};
		Map<String, Long> actual = NameOccurences.occurrencesWithChoice(input, Parity.ODD);
		assertThat(actual, is(expected));
	}

	@Test
	public final void testSortedOccurences() {
		Map<String, Long> expected = new HashMap<String, Long>() {
			{
				put("Marianne", 6L);
				put("Klara", 4L);
				put("Håkan", 2L);
				put("Annn-Marie", 1L);
			}
		};
		Map<String, Long> actual = NameOccurences.SortedOccurrences(input);
		assertThat(actual, is(expected));
	}

}
