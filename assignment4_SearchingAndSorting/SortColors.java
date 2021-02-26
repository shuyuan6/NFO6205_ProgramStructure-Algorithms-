package assignment4_SearchingAndSorting;

public class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int curr = 0;

        while (curr <= p2) {
            if (nums[curr] == 1) {
                curr++;
            } else if (nums[curr] == 0) {
                nums[curr] = nums[p0];
                nums[p0] = 0;
                p0++;
                curr++;
            } else {
                nums[curr] = nums[p2];
                nums[p2] = 2;
                p2--;
            }
        }
    }
}
