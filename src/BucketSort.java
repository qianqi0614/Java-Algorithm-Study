import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    public static double[] bucketSort(double[] array) {
        // 1、得到数列的最大值与最小值，并算出差值d
        double max = array[0];
        double min = array[0];
        for (double num : array) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        double d = max - min;
        // 2、初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        // 3、遍历原始数组，将每个元素放入桶中
        for (double num : array) {
            int i = (int) ((num - min) * (bucketNum - 1) / d);
            bucketList.get(i).add(num);
        }
        // 4、对每个捅内部进行排序
        for (LinkedList<Double> list : bucketList) {
            Collections.sort(list);
        }
        // 5、输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index++] = element;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[] {4.12,6.421,0.0023,2.123,8.122,4.12,10.09};
        System.out.println(Arrays.toString(bucketSort(array)));
    }
}
