package it.unibo.collections.sets;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Example class using {@link java.util.Set}.
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         *
         * 1) Builds a TreeSet containing Strings
         */
        final Collection<String> set = new TreeSet<>();
        /*
         * 2) Populates such Collection with all the Strings representing numbers ranging from "1" to
         * "20" (both included)
         */
        for (int i = 0; i <= ELEMS; i+=2) {
            set.add(Integer.toString(i));
        }
        /*
         * 3) Prints its content
         */
        System.out.println(set);
        /*
         * 4) Removes all those strings whose represented number is divisible by three.
         * Note: the method removeIf(Predicate) is not allowed.
         */
        for (int i = 1; i <= ELEMS; i++) {
            if (i % 3 == 0) {
                set.remove(Integer.toString(i));
            }
        }
        /*
         * 5) Prints the content of the Set using a for-each construct
         */
        System.out.print("[ ");
        for (final String s : set) {
            System.out.print(s+" ");
        }
        System.out.println("]");
        /*
         * 6) Verifies whether all the numbers left in the set are even
         */
        for (final String s : set) {
            if (Integer.parseInt(s) % 2 != 0) {
                System.out.println("Not all numbers are even");
                return;
            }
        }
        System.out.println("All numbers are even");
    }
}
