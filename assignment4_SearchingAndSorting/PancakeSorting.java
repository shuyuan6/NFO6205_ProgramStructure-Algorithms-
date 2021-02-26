package assignment4_SearchingAndSorting;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public void pancakeFlip(int[] arr, int k) {
        for (int i = 0; i < k / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = temp;
        }
    }

    public int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int currValue = arr.length;
        while (currValue > 0) {
            int positionShouldBe = currValue - 1;
            int currPosition = findIndex(arr, currValue);
            if (currPosition != positionShouldBe) {
                pancakeFlip(arr, currPosition + 1);
                if (currPosition + 1 > 1) {
                    res.add(currPosition + 1);
                }
                pancakeFlip(arr, currValue);
                if (currValue > 1) {
                    res.add(currValue);
                }
            }
            currValue--;
        }
        return res;
    }
}
