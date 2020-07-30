package Sort;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] array) {
        int lastExchangeIndex = 0;
        int sortBorder = array.length - 1;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void sort2(int[] array) {
        int frontExchangeIndex = 0;
        int rearExchangeIndex = 0;
        int sortFrontBorder = 0;
        int sortRearBorder = array.length - 1;
        int temp;
        for (int i = 0; i < array.length/2; i++) {
            boolean isSorted = true;
            // 奇数轮
            for (int j = sortFrontBorder; j < sortRearBorder; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    rearExchangeIndex = j;
                }
            }
            sortRearBorder = rearExchangeIndex;
            if (isSorted) {
                break;
            }
            isSorted = true;
            for (int j = sortRearBorder; j > sortFrontBorder; j--) {
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    isSorted = false;
                    frontExchangeIndex = j;
                }
            }
            sortFrontBorder = frontExchangeIndex;
            if (isSorted) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,9,8,7,6,5,4,10,11,12,13,14};
//        sort(array);
        sort2(array);
        System.out.println(Arrays.toString(array));
    }
}
