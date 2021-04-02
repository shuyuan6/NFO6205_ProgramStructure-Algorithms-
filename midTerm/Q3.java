package midTerm;

public class Q3 {
    //Assume that the length of nums is n
    //Time complexity: O(n)
    //Space complexity: O(1)
    public int getMaxConsecutiveOnes(int[] nums){
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                count++;
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Q3 test1 = new Q3();
        int[] nums1 = {0,1,0,1,1,0,1,1,1,0,0,0};
        System.out.println("The result of test1: " + test1.getMaxConsecutiveOnes(nums1));
        //Should be 3

        Q3 test2 = new Q3();
        int[] nums2 = {1,1,1,1,1,1,1,1};
        System.out.println("The result of test2: " + test2.getMaxConsecutiveOnes(nums2));
        //Should be 8

        Q3 test3 = new Q3();
        int[] nums3 = {0,0,0,0,0};
        System.out.println("The result of test3: " + test3.getMaxConsecutiveOnes(nums3));
        //Should be 0

        Q3 test4 = new Q3();
        int[] nums4 = {};
        System.out.println("The result of test4: " + test3.getMaxConsecutiveOnes(nums4));
        //Should be 0
    }
}
