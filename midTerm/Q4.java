package midTerm;

public class Q4 {
    //Assume that the length of the nums is n
    //Time complexity: O(logn)
    //Space complexity: O(1)
    public int getIndex(int[] nums, int x){
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > x) {
                right = mid - 1;
            }else if (nums[mid] < x) {
                left = mid + 1;
            }else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q4 test1 = new Q4();
        int[] nums1 = {2,4,4,4,6,7,7,7,8,9,9,9};
        System.out.println("The result of test1: " + test1.getIndex(nums1, 7));
        //Should be 5

        Q4 test2 = new Q4();
        int[] nums2 = {2,4,4,4,6,7,7,7,8,9,9,9};
        System.out.println("The result of test2: " + test2.getIndex(nums2, 2));
        //Should be 0

        Q4 test3 = new Q4();
        int[] nums3 = {2,4,4,4,6,7,7,7,8,9,9,9};
        System.out.println("The result of test3: " + test3.getIndex(nums3, 0));
        //Should be -1

        Q4 test4 = new Q4();
        int[] nums4 = {};
        System.out.println("The result of test4: " + test4.getIndex(nums4, 0));
        //Should be -1

    }
}
