package easy;

import java.util.Arrays;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 *
 * @author shc
 * @date 2020-03-22
 */
public class BinarySum {

    public void sum(String a, String b) {
        int[] intA;
        int[] intB;

        if (a.length() >= b.length()) {
            intA = changeType(a, a.length() + 1);
            intB = changeType(b, a.length() + 1);
        } else {
            intA = changeType(a, b.length() + 1);
            intB = changeType(b, b.length() + 1);
        }

        System.out.println(Arrays.toString(intA));
        System.out.println(Arrays.toString(intB));
        int[] result = new int[intA.length];
        // 进位
        int n = 0;
        for (int i = intA.length - 1; i >= 0; i--) {
            int temp = intA[i] + intB[i] + n;
            if (temp == 0) {
                result[i] = 0;
                n = 0;
            }
            if (temp == 1) {
                result[i] = 1;
                n = 0;
            }
            if (temp == 2) {
                result[i] = 0;
                n = 1;
            }
            if (temp == 3) {
                result[i] = 1;
                n = 1;
            }
        }

        System.out.println(Arrays.toString(result));
    }

    public int[] changeType(String a, int length) {

        int[] result = new int[length];
        String[] as = a.split("");
        int j = 0;
        for (int i = as.length - 1; i >= 0; i--) {
            result[length - 1 - j] = Integer.parseInt(as[i]);
            j++;
        }
        return result;
    }


    public static void main(String[] args) {
        BinarySum binarySum = new BinarySum();

        binarySum.sum("1011111", "101");
    }
}
