import sun.font.CreatedFontTracker;

import javax.swing.plaf.ListUI;
import java.util.*;

public class test2 {
    public static void main(String[] args) {
//        int[] array = new int[] {1,2,5,4,7,4,4,2,8,10};
//        int[] array2 = new int[] {96,91,91,90,91,95};
//        System.out.println(Arrays.toString(countSort(array)));
//        System.out.println(Arrays.toString(countSort(array2)));
//        double[] array3 = new double[] {4.12,6.421,0.0023,2.123,8.122,4.12,10.09};
//        System.out.println(Arrays.toString(bucketSort(array3)));
//        List<List<Integer>> triangle = generate(10);
//        for (List<Integer> list : triangle) {
//            list.forEach(integer -> System.out.print(integer+ " "));
//            System.out.println();
//        }
//        getRow(3);
        System.out.println(isUnique("leetcode"));
    }


    private static int[] countSort(int[] array) {
        int max = array[0], min = array[0];
        for (int num : array) {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        int len = max - min;
        int[] countArray = new int[len + 1];
        for (int num : array) {
            countArray[num - min]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }
        int[] sortedArray = new int[array.length];
        for (int i = array.length-1; i >= 0; i--) {
            sortedArray[--countArray[array[i] - min]] = array[i];
        }
        return sortedArray;
    }

    private static double[] bucketSort(double[] array) {
        double max = array[0], min = array[0];
        for (double num : array) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        double d = max - min;

        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < array.length; i++) {
            bucketList.add(new LinkedList<>());
        }

        for (double num : array) {
            int i = (int) ((num - min) * (bucketNum - 1) / d);
            bucketList.get(i).add(num);
        }

        for (LinkedList<Double> list : bucketList) {
            Collections.sort(list);
        }
        int index = 0;
        double[] sortedArray = new double[array.length];
        for (LinkedList<Double> list : bucketList) {
            for (Double num : list) {
                sortedArray[index++] = num;
            }
        }
        return sortedArray;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangel = new ArrayList<>();
        if (numRows <= 0) {
            return triangel;
        }

        triangel.add(new ArrayList<>());
        triangel.get(0).add(1);

        for (int rowNums = 1; rowNums < numRows; rowNums++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangel.get(rowNums-1);
            row.add(1);
            for (int j = 1; j < rowNums; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangel.add(row);
        }
        return triangel;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex+1);
        for (int i = 0; i < rowIndex + 1; i++) {
            if (i == 0) {
                row.add(1);
            } else {
                long val = (long) row.get(i - 1) * (long) (rowIndex + 1 - i) / i;
                row.add((int) val);
            }
        }
        return row;
    }

    public static boolean isUnique(String astr) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < astr.length(); i++) {
            char ch = astr.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.println(map.values());
        for (int i : map.values()) {
            if (i > 1) {
                return false;
            }
        }
        return false;
    }
}
