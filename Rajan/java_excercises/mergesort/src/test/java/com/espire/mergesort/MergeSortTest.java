/**
 * 
 */
package com.espire.mergesort;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author rajan.lahoti
 *
 */
public class MergeSortTest {
	Integer[] array = { 9, 3, 21, 60, 94, 86 };
	Integer[] sortedArray = { 3, 9, 21, 60, 86, 94 };

	@Test
	public void test() {
		MergeSort.mergerSort(array, new Integer[array.length], 0, array.length - 1);
		assertArrayEquals(sortedArray, array);
	}
}
