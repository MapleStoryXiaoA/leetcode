package leetcode.editor.cn;

public class P104二叉树的最大深度 {


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

    class Solution {
        int maxDepth = 0;

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            maxDepth = 1;
            maxDepth(1, root);
            return maxDepth;
        }

        private void maxDepth(int depth, TreeNode node) {
            if (node == null) {
                maxDepth = Math.max(depth - 1, maxDepth);
            } else {
                depth += 1;
                maxDepth(depth, node.left);
                maxDepth(depth, node.right);
            }
        }
    }
}
