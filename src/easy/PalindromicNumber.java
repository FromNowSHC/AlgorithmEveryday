package easy;

/**
 * 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * @author shc
 * @date 2019-04-27
 */
public class PalindromicNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String par = String.valueOf(x);
        String[] split = par.split("");
        if (split.length == 1) {
            return true;
        }
        boolean result = true;
        for (int i = 0; i <= (split.length / 2); i++) {
            if (!split[i].equals(split[split.length - i - 1])) {
                result = false;
            }
        }
        return result;
    }

    /**
     *不将整数转为字符串
     * 1.只反转 int 数字的一半,
     * 例如，输入 1221，我们可以将数字“1221”的后半部分从“21”反转为“12”，并将其与前半部分“12”进行比较，
     * 因为二者相同，我们得知数字 1221 是回文。
     *
     * 2.我们将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字
     * @param x
     * @return
     */
    public static boolean isPalindromeSecond(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
//            System.out.println(revertedNumber + "======" + x );
        }
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeSecond(12321));
    }
}
