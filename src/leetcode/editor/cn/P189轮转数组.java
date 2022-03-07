package leetcode.editor.cn;

import java.util.Arrays;

public class P189轮转数组 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            int[] d = new int[length * 2];
            System.arraycopy(nums, 0, d, 0, length);
            System.arraycopy(nums, 0, d, length, length);
            int index = k % length;
            System.arraycopy(d, length-index, nums, 0, length);
        }
    }
}
