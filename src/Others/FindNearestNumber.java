package Others;

import java.util.Arrays;
import java.util.Scanner;

public class FindNearestNumber {
    public static void main(String[] args) {
        int[] inputNumber = inputNumber();
        int[] nextNumber = new int[0];
        int[] prevNumber = new int[0];
        try {
            prevNumber = findPrevNumber(inputNumber);
            System.out.print("prevNumber: ");
            outputNumbers(prevNumber);
        } catch (NullPointerException e) {
            System.out.println("Not found");
        }
        System.out.print("inputNumber: ");
        outputNumbers(inputNumber);
        try {
            nextNumber = findNextNumber(inputNumber);
            System.out.print("nextNumber: ");
            outputNumbers(nextNumber);
        } catch (NullPointerException e) {
            System.out.println("Not found");
        }
    }

    public static int[] findPrevNumber(int[] numbers) {
        int index = findPrevTransferPoit(numbers);
        if (index == 0) {
            return null;
        }
        int[] numbersCopy = Arrays.copyOf(numbers,numbers.length);
        exchangePrev(numbersCopy, index);
        reserve(numbersCopy,index);
        return numbersCopy;
    }

    public static int[] findNextNumber(int[] numbers) {
        // 1、从后往前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findNextTransferPoint(numbers);
        // 如果数字置换边界为0，那么这个数组已经是逆序，无法得到更大的数字，返回null
        if (index == 0) {
            return null;
        }
        // 2、把逆序区域的前一位和逆序区域中刚刚大于他的数字交换位置
        // 复制并入惨，避免直接修改该入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeNext(numbersCopy, index);
        // 3、把原来的逆序区域转为顺序
        reserve(numbersCopy, index);
        return numbersCopy;
    }

    private static void exchangeNext(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
    }

    private static void exchangePrev(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head > numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
    }

    private static void reserve(int[] num, int index) {
        for (int i = index, j = num.length - 1; i<j;i++,j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }

    private static int findPrevTransferPoit(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int findNextTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static int[] inputNumber() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int numbers[] = new int[input.length()];
        for (int i = 0; i < input.length();i++) {
            char c = input.charAt(i);
            numbers[i] = Character.getNumericValue(c);
        }
        return numbers;
    }

    public static void outputNumbers(int[] numbers) {
        for (int i : numbers) {
            System.out.print(i);
        }
        System.out.println();
    }
}
