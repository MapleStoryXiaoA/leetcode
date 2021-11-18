package leetcode.editor.cn;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P35搜索插入位置 {

    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 4));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int leftIndex = 0;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int middleIndex = (rightIndex + leftIndex) / 2;
                if (target > nums[middleIndex]) {
                    leftIndex = middleIndex + 1;
                }
                if (target == nums[middleIndex]) {
                    return middleIndex;
                }
                if (target < nums[middleIndex]) {
                    rightIndex = middleIndex;
                }
            }
            return target <= nums[leftIndex] ? leftIndex : leftIndex + 1;
        }
    }
}
