import java.util.Arrays;
import java.util.Scanner;

public class ScannerStudy {


    public static void main(String[] args) {
//        System.out.println("请输入几个数并用逗号隔开：");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        String[] arr  = str.split(",");
//        int[] b = new int[arr.length];
//        for(int j = 0; j<b.length; j++) {
//            b[j] = Integer.parseInt(arr[j]);
//            System.out.print(b[j]+" ");
//        }

        System.out.println("请输入几个数并用空格隔开：");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int[] b = new int[arr.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Arrays.toString(b));

//        System.out.println("请输入三个数：");
//        Scanner in = new Scanner(System.in);
//        int[] b=new int[31];
//        for(int i=0;i<b.length;i++) {
//            b[i] = in.nextInt();
//        }
//        System.out.println(Arrays.toString(b));
    }
}
