package com.tornyak.combinatorics;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Sets {

    public static <T> Set<Set<T>> subsets(Set<T> s) {
        return getFirst(s).
                map(first -> append(first, subsets(getRest(s)))).
                orElse(Set.of(Set.of()));
    }

    private static <T> Set<Set<T>> append(T element, Set<Set<T>> sets) {
        Set<Set<T>> result = new HashSet<>(sets);
        Set<Set<T>> newSets = sets.stream().
                map(s -> addToSet(element, s)).
                collect(Collectors.toSet());
        result.addAll(newSets);
        return result;
    }

    private static <T> Set<T> addToSet(T element, Set<T> set) {
        Set<T> result = new HashSet<>(set);
        result.add(element);
        return result;
    }

    private static <T> Set<T> getRest(Set<T> s) {
        return s.stream().skip(1).collect(Collectors.toSet());
    }

    private static <T> Optional<T> getFirst(Set<T> s) {
        return s.stream().findFirst();
    }
}
