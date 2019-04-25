package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author shc
 * @date 2019-04-25
 */
public class Solution {

    /**
     *  自己写的暴力破解
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] == target - nums[j])) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     *  答案使用Map巧妙解答
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumOne(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}
