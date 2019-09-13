package com.tornyak.combinatorics;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SetsTest {

    @Test
    public void subsets() {
        Set<Set<Integer>> subsets = Sets.subsets(Set.of(1, 2, 3));
        Set<Set<Integer>> expected = Set.of(
                Set.of(),
                Set.of(1),
                Set.of(2),
                Set.of(3),
                Set.of(1, 2),
                Set.of(1, 3),
                Set.of(2, 3),
                Set.of(1, 2, 3)
        );
        assertEquals(expected, subsets);
    }

    @Test
    public void subsetsOfEmptySet() {
        Set<Set<Integer>> subsets = Sets.subsets(Set.of());
        assertEquals(Set.of(Set.of()), subsets);
    }
}