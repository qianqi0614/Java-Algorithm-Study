public class test {
    public static void main(String[] args) {
        System.out.println(reserve(-134521));
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        int temp = x;
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
//            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE%10)) {
//                return 0;
//            }
//            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE%10)) {
//                return 0;
//            }
            res = res * 10 + pop;
        }
        System.out.println(temp);
        return temp == res;
    }
    public static int reserve(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE%10)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE%10)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }
}