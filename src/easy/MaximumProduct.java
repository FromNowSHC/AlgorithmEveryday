package easy;

import java.util.Arrays;

/**
 * @author shc
 * @date 2020-09-04
 */
public class MaximumProduct {

    /**
     * 排序后判断正数有几个
     */
    public int maximum(int[] nums) {
        int lagerThanZero = nums[0] > 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {
                int currentNum = nums[i];
                int j = i - 1;
                for (; j >= 0 && currentNum < nums[j]; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[j + 1] = currentNum;
            }
        }


        return 0;
    }

    /**
     * 我们将数组进行升序排序，如果数组中所有的元素都是非负数，那么答案即为最后三个元素的乘积。
     * 如果数组中出现了负数，那么我们还需要考虑乘积中包含负数的情况，
     * 显然选择最小的两个负数和最大的一个正数是最优的，即为前两个元素与最后一个元素的乘积。
     * 上述两个结果中的较大值就是答案。注意我们可以不用判断数组中到底有没有正数，0 或者负数，
     * 因为上述两个结果实际上已经包含了所有情况，最大值一定在其中。
     */
    public int maximumFirst(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    /**
     * 通过分析可知只需要找出最小的两个数和最大的三个数，即可获得结果；
     */
    public int maximumSecond(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {
                // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {

    }
}
