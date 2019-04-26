package easy;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 *
 * @author shc
 * @date 2019-04-26
 */
public class IntegerInversion {

    public static int reverse(int x) {
        int result = 0;
        String temp = "" + x;
        try{
            if (x >= 0) {
                StringBuilder stringBuilder = new StringBuilder(temp);
                temp = stringBuilder.reverse().toString();
                result = Integer.valueOf(temp);
            } else {
                String substring = temp.substring(1, temp.length());
                StringBuilder stringBuilder = new StringBuilder(substring);
                temp = stringBuilder.reverse().toString();
                result = Integer.valueOf("-" + temp);
            }
        }catch (Exception e){
            return 0;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }
}
