package leetcode.editor.cn;

import java.util.Arrays;

public class 排序_快速排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5};
        new Solution().sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    static class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private static void quickSort(int[] arr, int left, int right) {
            if (left >= right) {
                return;
            }
            int newLeft = left;
            int newRight = right;
            int value = arr[newRight];
            while (newLeft < newRight) {
                while (arr[newLeft] <= value && newLeft < newRight) {
                    newLeft++;
                }
                while (arr[newRight] >= value && newLeft < newRight) {
                    newRight--;
                }
                if (newLeft < newRight) {
                    swap(arr, newLeft, newRight);
                }
            }
            arr[right] = arr[newLeft];
            arr[newLeft] = value;
            quickSort(arr, left, newLeft - 1);
            quickSort(arr, newLeft + 1, right);
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
