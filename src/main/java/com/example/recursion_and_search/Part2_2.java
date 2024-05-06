package com.example.recursion_and_search;

import static java.util.Arrays.binarySearch;
public class Part2_2 {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25};
        int searchValue = 15;
        int index = binarySearch(arr, searchValue);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}