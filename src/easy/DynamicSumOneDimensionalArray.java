package easy;

import java.util.Arrays;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1]
 * <p>
 * 示例 3：
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *
 * @author shc
 * @date 2020-08-31
 */
public class DynamicSumOneDimensionalArray {

    public static int[] runningSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
        }
        return nums;
    }

    public static int[] runningSumBetter(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(runningSumBetter(nums)));
    }
}
