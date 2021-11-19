package leetcode.editor.cn;

public class P108将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }


        private TreeNode sortedArrayToBST(int[] nums, int leftIndex, int rightIndex) {
            if (leftIndex > rightIndex) {
                return null;
            }
            int middleIndex = (leftIndex + rightIndex) / 2;
            TreeNode root = new TreeNode(nums[middleIndex]);
            root.left = sortedArrayToBST(nums,leftIndex,middleIndex-1);
            root.right = sortedArrayToBST(nums,middleIndex+1,rightIndex);
            return root;
        }
    }
}
