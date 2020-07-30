package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {1,6,4,3,7,8,9,5,10,2};
        System.out.println(Arrays.toString(mergeSort(nums, 0, nums.length - 1)));
    }

    public static int[] mergeSort(int[] nums, int start, int end) {
        if (start >= end) {return nums;}

        return nums;
    }

}
