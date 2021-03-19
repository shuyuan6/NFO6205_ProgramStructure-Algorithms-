package assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> helper(int[] nums, int i) {
        int low = i + 1;
        int high = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (low < high) {
            int sum = nums[low] + nums[high] + nums[i];
            if (sum < 0 || ( low - 1 > i && nums[low] == nums[low - 1])) {
                low++;
            } else if (sum > 0 || (high + 1 < nums.length - 1 && nums[high] == nums[high + 1])) {
                high--;
            } else {
                res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--;

            }
        }
        return res;
    }



    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> part = new ArrayList<>();
            if (i == 0 || nums[i] != nums[i - 1]) {
                part = helper(nums, i);
            }
            res.addAll(part);
        }

        return res;
    }
}
