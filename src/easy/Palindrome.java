package easy;

/**
 * @author shc
 * @date 2020-09-06
 */
public class Palindrome {
    public static boolean isPalindrome(int x) {
        String originStr = x + "";
        StringBuilder str = new StringBuilder(originStr);
        return  originStr.equals(str.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1811));
    }
}
