
package com.jaredengler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortedArrayDeduplicatorShould {

    SortedArrayDeduplicator sortedArrayDeduplicator;

    @BeforeEach
    void setup() {
        sortedArrayDeduplicator = new SortedArrayDeduplicator();
    }

    @Test
    void returnZeroIfInputArrayIsLengthZero() {
        int actual = sortedArrayDeduplicator.removeDuplicates(new int[0]);
        assertThat(actual, is(equalTo(0)));
    }

    @Test
    void returnZeroIfInputArrayIsLengthOne() {
        int actual = sortedArrayDeduplicator.removeDuplicates(new int[1]);
        assertThat(actual, is(equalTo(1)));
    }

    @Test
    void notDeduplicateIfTwoAdajacentDifferentValues() {
        int actual = sortedArrayDeduplicator.removeDuplicates(new int[] { 1, 2 });
        assertThat(actual, is(equalTo(2)));
    }

    @Test
    void deDuplicateIfTwoAdajacentSameValues() {
        int actual = sortedArrayDeduplicator.removeDuplicates(new int[] { 1, 1 });
        assertThat(actual, is(equalTo(1)));
    }

    @Test
    void duplicateIfThreeAjacentDifferentValues() {
        int actual = sortedArrayDeduplicator.removeDuplicates(new int[] { 1, 2, 3 });
        assertThat(actual, is(equalTo(3)));
    }

    @Test
    void duplicateIfTwoAjacentDifferentValuesFollowedBySame() {
        int actual = sortedArrayDeduplicator.removeDuplicates(new int[] { 1, 1, 2 });
        assertThat(actual, is(equalTo(2)));
    }

    @Test
    void testForRandomSortedArray() {

        IntStream.range(0, 10000).parallel().forEach(i -> {

            List<Integer> nonDistinctSortedList =
                Stream.generate(Math::random).limit(i)
                    .mapToDouble(d -> d * 100)
                    .mapToInt(d -> Double.valueOf(d).intValue())
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());

            int[] distinctSortedArray =
                nonDistinctSortedList.stream()
                    .distinct()
                    .mapToInt(Integer::valueOf)
                    .toArray();

            int[] nonDistinctSortedArray =
                nonDistinctSortedList.stream()
                    .mapToInt(Integer::valueOf)
                    .toArray();

            int expectedLength =
                distinctSortedArray.length;

            int actualLength =
                sortedArrayDeduplicator.removeDuplicates(nonDistinctSortedArray);

            assertThat(expectedLength, is(equalTo(actualLength)));

        });

    }

}
