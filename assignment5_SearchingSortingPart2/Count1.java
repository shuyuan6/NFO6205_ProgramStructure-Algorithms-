package assignment5_SearchingSortingPart2;

public class Count1 {

    public int countOnes(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == high || arr[mid + 1] == 0) && arr[mid] == 1) {
                return mid + 1;
            } else if (arr[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Count1 count1 = new Count1();
        int[] arr1 = {0, 0, 0, 0, 0, 0};
        int[] arr2 = {1, 1, 0, 0, 0, 0, 0};
        int[] arr3 = {1, 1, 1, 1, 1, 1};

        System.out.println(count1.countOnes(arr1));
        System.out.println(count1.countOnes(arr2));
        System.out.println(count1.countOnes(arr3));

    }
}
