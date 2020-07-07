import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] array,int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition2(array, startIndex, endIndex);
        sort(array, startIndex, pivotIndex - 1);
        sort(array,pivotIndex + 1, endIndex);
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int p = array[left];
                array[left] = array[right];
                array[right] = p;
            }
        }

        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }

    private static int partition2(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
                int p = array[mark];
                array[mark] = array[i];
                array[i] = p;
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,7,6,5,3,2,8,1};
        sort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
