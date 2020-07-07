public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int number) {
        return (number - 1 & number) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(10));
    }
}
