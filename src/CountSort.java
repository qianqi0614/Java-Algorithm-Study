import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] array = new int[] {3,4,5,6,7,4,2,6,9,2,1,8,10};
        int[] array2 = new int[] {94,90,93,92,91,95};
        int[] array3 = new int[] {94,90,92,92,92,95};
        System.out.println(Arrays.toString(countSort(array)));
        System.out.println(Arrays.toString(countSort2(array2)));
        System.out.println(Arrays.toString(countSort3(array3)));
    }

    public static int[] countSort(int[] array) {
        int max = array[0];
        // 1、找出最大值，确定统计数组的长度
        for (int num : array) {
            max = Math.max(max,num);
        }
        // 2、根据传入数组的最大值确定统计数组的长度
        int[] countArray = new int[max+1];
        // 3、遍历传入数组，填充统计数组
        for(int num : array) {
            countArray[num]++;
        }
        // 4、遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    public static int[] countSort2(int[] array) {
        int max = array[0], min = array[0];
        for (int num : array) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] countArray = new int[max-min+1];
        for (int num : array) {
            countArray[num-min]++;
        }
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i+min;
            }
        }
        return sortedArray;
    }

    public static int[] countSort3(int[] array) {
        int max = array[0], min = array[0];
        for (int num : array) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int d = max - min;
        int[] countArray = new int[d + 1];
        for (int num : array) {
            countArray[num-min]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[--countArray[array[i]-min]-1] = array[i];
        }
        return sortedArray;
    }
}
