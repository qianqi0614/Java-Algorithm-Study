import java.util.Arrays;

public class MyBubbleSort {
    public static void main(String[] args) {
        int[] nums = {1,4,3,6,7,8,2,10,9,5};
        sort1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort1(int[] nums) {
        int lastExchangeIndex = 0;
        int border = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < border; j++) {
                if (nums[j] > nums[j+1]) {
                    nums[j] ^= nums[j+1];
                    nums[j+1] ^= nums[j];
                    nums[j] ^= nums[j+1];
                    lastExchangeIndex = j;
                    isSorted = false;
                }
            }
            border = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void sort2(int[] nums) {
        int frontExchangeIndex = 0, rearExchangeIndex = 0;
        int frontBorder = 0, rearBorder = nums.length - 1;
        for (int i = 0; i < rearBorder; i++) {

        }
    }
}
