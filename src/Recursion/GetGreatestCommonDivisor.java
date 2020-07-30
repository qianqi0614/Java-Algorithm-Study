package Recursion;

public class GetGreatestCommonDivisor {
    /**
     * 辗转相除法（欧几里得算法）：
     * 两个正整数 a 和 b（a > b）,它们的最大公约数等于 a 除以 b 的余数 c 和 b 之间的最大公约数
     * @param a
     * @param b
     */
    public static int getGreatestCommonDivisor(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisor(big % small, small);
    }

    /**
     * 更相减损术：
     * 两个正整数 a 和 b （a > b）,它们得最大公约数等于 a - b 得差值 c 和较小数 b 的最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV2(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        return getGreatestCommonDivisorV2(big - small, small);
    }

    /**
     * 当 a 和 b 均为偶数时，gcd(a,b) = 2 x gcd(a/2,b/2) = 2 x gcd(a>>1,b>>1)
     * 当 a 为偶数，b 为奇数时，gcd(a,b) = gcd(a/2,b) = gcd(a>>1,b)
     * 当 a 为奇数，b 为偶数时，gcd(a,b) = gcd(a,b/2) = gcd(a,b>>1)
     * 当 a 和 b 均为奇数时，先利用更相减损术运算一次，gcd(a,b) = gcd(b,a-b)，此时 a - b 必然时偶数，然后继续进行移位运算
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisorV3(int a, int b) {
        if(a == b) {
            return a;
        }
        if ((a&1) == 0 && (b&1) == 0) {
            return getGreatestCommonDivisorV3(a >> 1,b >> 1) << 1;
        } else if ((a&1) == 0 && (b&1) != 0) {
            return getGreatestCommonDivisorV3(a >> 1, b);
        } else if ((a&1) != 0 && (b&1) == 0) {
            return getGreatestCommonDivisorV3(a, b >> 1);
        } else {
            int big = Math.max(a,b);
            int small = Math.min(a,b);
            return getGreatestCommonDivisorV3(big-small, small);
        }
    }

    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;
        startTime = System.nanoTime();
        System.out.println(getGreatestCommonDivisor(25,5));
        System.out.println(getGreatestCommonDivisor(100,80));
        System.out.println(getGreatestCommonDivisor(1000,1001));
        endTime = System.nanoTime();
        System.out.println("程序运行了" + (endTime - startTime) +"纳秒");
        System.out.println("------------------");
        startTime = System.nanoTime();
        System.out.println(getGreatestCommonDivisorV2(25, 5));
        System.out.println(getGreatestCommonDivisorV2(100, 80));
        System.out.println(getGreatestCommonDivisorV2(1000,1001));
        endTime = System.nanoTime();
        System.out.println("程序运行了" + (endTime - startTime) +"纳秒");

        System.out.println("------------------");
        startTime = System.nanoTime();
        System.out.println(getGreatestCommonDivisorV3(25, 5));
        System.out.println(getGreatestCommonDivisorV3(100, 80));
        System.out.println(getGreatestCommonDivisorV3(1000,1001));
        endTime = System.nanoTime();
        System.out.println("程序运行了" + (endTime - startTime) +"纳秒");
    }
}
