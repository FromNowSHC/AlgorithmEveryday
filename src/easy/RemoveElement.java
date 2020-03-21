package easy;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * <p>
 * <p>
 * 思考：像这种要求0(1)的问题，一般考虑元素的交换和覆盖
 * <p>
 *
 * @author shc
 * @date 2020-03-21
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
            } else {
                i++;
            }
        }
        return i;
    }


    public int removeElementTwo(int[] nums, int val) {
        int i = 0;
        int n = nums.length - 1;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }


}
