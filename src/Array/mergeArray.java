package Array;

import java.util.Arrays;

public class mergeArray {


    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[] array1 = {2, 3, 4, 5};
        int[] array2 = {9, 8, 1};
        int[] newArray = merge(array1,m,array2,n);
        System.out.println(Arrays.toString(newArray));
    }

    public static int[] merge(int[] array1, int m, int[] array2, int n) {
        int[] newArray = new int[m + n];
        int i = m - 1;
        int j = 0;
        int k = m + n - 1;
        while (i >= 0 && j < n) {
            newArray[k--] = array1[i] > array2[j] ? array1[i--] : array2[j++];
        }
        newArray[0] = Math.min(array1[0], array2[n-1]);
        return newArray;
    }

}
