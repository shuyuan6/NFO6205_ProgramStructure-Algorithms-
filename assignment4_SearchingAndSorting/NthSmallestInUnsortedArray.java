package assignment4_SearchingAndSorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NthSmallestInUnsortedArray {
    public int findNthSmallestSimpleWay(int[] arr, int n) {
        Arrays.sort(arr);
        return arr[n - 1];
    }

    public int findNthSmallest(int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer int1, Integer int2) {
                return int2 - int1;
            }
        });

        for (int number : arr) {
            pq.add(number);
            if (pq.size() > n) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        NthSmallestInUnsortedArray nthSmallestInUnsortedArray = new NthSmallestInUnsortedArray();
        int arr[] = { 12, 3, 5, 7, 19 };
        int k = 4;
        System.out.println("K'th smallest element is " + nthSmallestInUnsortedArray.findNthSmallestSimpleWay(arr, k));
        System.out.print("K'th smallest element is " + nthSmallestInUnsortedArray.findNthSmallest(arr, k));
    }

}
