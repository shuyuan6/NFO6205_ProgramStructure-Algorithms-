package assignment5_SearchingSortingPart2;

import java.util.*;

public class FindKCloesestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                if (Math.abs(n1) != Math.abs(n2)) {
                    return Math.abs(n1) - Math.abs(n2);
                } else {
                    return n1 - n2;
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i] - x);
        }

        while (k > 0) {
            res.add(pq.poll() + x);
            k--;
        }
        Collections.sort(res);

        return res;
    }

    public static void main(String[] args) {
        FindKCloesestElements findKCloesestElements = new FindKCloesestElements();
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        System.out.println(findKCloesestElements.findClosestElements(arr, k, x));
    }
}
