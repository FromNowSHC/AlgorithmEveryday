package easy;

import java.util.Arrays;

/**
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 *
 * @author shc
 * @date 2020-09-30
 */
public class ChoseBreakfast {

    public static int breakfastNumberFalse(int[] staple, int[] drinks, int x) {
        int result = 0;
        for (int i = 0; i < staple.length; i++) {
            if (staple[i] >= x) {
                continue;
            }
            for (int j = 0; j < drinks.length; j++) {
                if (drinks[j] >= x) {
                    continue;
                }
                if (staple[i] + drinks[j] <= x) {
                    result += 1;
                }
            }
        }
        return result % 1000000007;
    }



    /**
     * 二分搜索找出比目标值小的元素的个数
     *
     * @param arr 数组
     * @param tar 目标值
     * @return 个数
     */
    public static int search(int[] arr, int tar) {
        int begin = 0;
        int end = arr.length;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (arr[mid] <= tar) {
                // 为什么不需要返回值不需要加1， 在此处
                begin = mid + 1;
            } else if (arr[mid] > tar) {
                end = mid;
            }
        }
        return begin;
    }

    public static int breakfastNumberTrue(int[] staple, int[] drinks, int x) {
        long cnt = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        for (int i : staple) {
            if (i > x) {
                break;//如果i直接大于x了就可以直接退出循环了
            } else {
                int index = search(drinks, x - i);
                cnt += index;
            }
        }
        return (int) (cnt % 1000000007);
    }


    public static void main(String[] args) {
        int[] staple = {10, 20, 5};
        int[] drinks = {5, 5, 2};
        int x = 15;
        System.out.println(breakfastNumberFalse(staple, drinks, x));
    }
}
