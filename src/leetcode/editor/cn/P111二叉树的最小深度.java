package leetcode.editor.cn;

public class P111二叉树的最小深度 {

    public class TreeNode {
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
        int minDepth = Integer.MAX_VALUE;

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            minDepth(1, root);
            return minDepth;
        }

        private void minDepth(int depth, TreeNode node) {
            if (node.left == null && node.right == null) {
                minDepth = Math.min(depth, minDepth);
            }else {
                if (node.left != null) {
                    minDepth(depth + 1, node.left);
                }
                if (node.right != null) {
                    minDepth(depth + 1, node.right);
                }
            }
        }
    }
}
