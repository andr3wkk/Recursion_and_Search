package com.example.recursion_and_search;

public class Part2_2 {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25};
        int searchValue = 25;
        int index = binarySearch(arr, searchValue);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
    public static int binarySearch(int[] a, int search) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == search) {
                return mid;
            } else if (a[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}