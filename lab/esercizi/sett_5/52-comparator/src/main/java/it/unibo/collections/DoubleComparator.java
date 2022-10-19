package it.unibo.collections;

import java.util.Comparator;

public class DoubleComparator implements Comparator<String> {
    private double toDouble (String s) {
        return Double.parseDouble(s);
    }
    @Override
    public int compare(String s1, String s2) {
        return Double.compare(this.toDouble(s1), this.toDouble(s2));
    }
}
