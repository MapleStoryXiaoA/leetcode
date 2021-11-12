package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 */
public class P26删除有序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3, 3, 4};
        new Solution().removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int fast = 0, slow = 0;
            while (fast < n) {
                if (nums[fast] == nums[slow]) {
                    fast++;
                } else {
                    nums[slow + 1] = nums[fast];
                    slow++;
                }
            }
            return slow + 1;
        }
    }
}
