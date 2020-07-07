import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int[] inputNumber = inputNumber();
        try {
            System.out.print("prevNumber: ");
            output(findPrevNumber(inputNumber));
        } catch (NullPointerException e) {
            System.out.println("Not found!");
        }
        try {
            System.out.println("nextNmuber: ");
            output(findNextNumber(inputNumber));
        } catch (NullPointerException e) {
            System.out.println("Not found!");
        }
    }

    private static int[] findPrevNumber(int[] inputNumber) {
        int index = findPrevTransfer(inputNumber);
        if (index == 0) {
            return null;
        }
        int[] numberCopy = Arrays.copyOf(inputNumber, inputNumber.length);
        exchangePrev(numberCopy, index);
        reserve(numberCopy, index);
        return numberCopy;

    }

    private static void exchangePrev(int[] nums, int index) {
        int temp = nums[index - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > temp) {
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }

    private static int[] findNextNumber(int[] inputNumber) {
        int index = findNextTransfer(inputNumber);
        if (index == 0) {
            return null;
        }
        int[] numberCopy = Arrays.copyOf(inputNumber, inputNumber.length);
        exchangeNext(numberCopy, index);
        reserve(numberCopy, index);
        return numberCopy;
    }

    private static void exchangeNext(int[] nums, int index) {
        int temp = nums[index - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < temp) {
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }

    private static void reserve(int[] nums, int index) {
        for (int i = index, j = nums.length - 1; i < j; i++,j--) {
            nums[i] = nums[i] + nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

    private static int findNextTransfer(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int findPrevTransfer(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] inputNumber() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] inputNumber = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            inputNumber[i] = Character.getNumericValue(c);
        }
        return inputNumber;
    }

    private static void output(int[] prevNumber) {
        for (int i : prevNumber) {
            System.out.print(i);
        }
        System.out.println();
    }
}