package com.example.recursion_and_search;

import static java.util.Arrays.binarySearch;
public class Part2_3 {
    public static void main(String[] args) {
        int[] a = {5, 10, 15, 20, 25};
        int searchValue = 15;
        int index = recursiveBinarySearch(a, searchValue, 0, a.length - 1);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    public static int recursiveBinarySearch(int[] a, int search, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (a[mid] == search) {
            return mid;
        } else if (a[mid] < search) {
            return recursiveBinarySearch(a, search, mid + 1, high);
        } else {
            return recursiveBinarySearch(a, search, low, mid - 1);
        }
    }
}
