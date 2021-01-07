import java.util.Arrays;

public class Bytetest {

    public static void main(String[] args) {
        int a[] = {4, 3, 6, 5, 1, 2};
        int b[] = Arrays.copyOf(a, 4);
        int c[] = Arrays.copyOfRange(a, 2, 4 + 1);
        System.arraycopy(a,0,a,0,4);
        for (int i = 0; i < b.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println();

        for (int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");
        System.out.println();
    }

}
