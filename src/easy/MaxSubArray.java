package easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 这个不容易想到
 * @author shc
 * @date 2019-04-10
 **/
public class MaxSubArray {

    /**
     * 啊啊啊啊啊啊啊啊啊
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
            System.out.println(res + "-" + sum);
        }
        return res;
    }


    public static void main(String[] args){
        int[] nums =  {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);
        System.out.println(Math.max(1,1));
    }

}
