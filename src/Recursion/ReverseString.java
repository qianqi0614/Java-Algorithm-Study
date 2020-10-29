package Recursion;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("qq is a coder!"));
    }

    public static String reverseString(String sentence) {
        return sentence.isEmpty() ? sentence : reverseString(sentence.substring(1)) + sentence.charAt(0);
    }
}
