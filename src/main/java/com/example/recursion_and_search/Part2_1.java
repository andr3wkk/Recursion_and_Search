package com.example.recursion_and_search;
import java.util.ArrayList;

public class Part2_1 {
    public static int recLinearSearch(ArrayList<String> list, String key, int beginIdx, int endIdx) {
        if (beginIdx > endIdx) {
            return -1;
        }

        if (list.get(beginIdx).equals(key)) {
            return beginIdx;
        }
        return recLinearSearch(list, key, beginIdx + 1, endIdx);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("iPhone");
        list.add("iPad");
        list.add("MacBook");
        list.add("iMac");

        // Example usage:
        int index = recLinearSearch(list, "iPad", 0, list.size() - 1);
        System.out.println("Index of 'iPad': " + index);  // Should print 1

        index = recLinearSearch(list, "Apple Watch", 0, list.size() - 1);
        System.out.println("Index of 'Apple Watch': " + index);  // Should print -1
    }
}
