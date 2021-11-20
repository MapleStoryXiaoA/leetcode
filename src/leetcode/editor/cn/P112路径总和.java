package leetcode.editor.cn;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P112路径总和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        System.out.println(new Solution().hasPathSum(root, -5));
    }

    public static class TreeNode {
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root==null){
                return false;
            }
            return hasPathSum(0, root, targetSum);
        }

        private boolean hasPathSum(int sum, TreeNode node, int targetSum) {
            sum = sum + node.val;
            if (node.left == null && node.right == null) {
                return sum == targetSum;
            }
            if (node.left == null) {
                return hasPathSum(sum, node.right, targetSum);
            }
            if (node.right == null) {
                return hasPathSum(sum, node.left, targetSum);
            }
            if (hasPathSum(sum, node.left, targetSum)) {
                return true;
            } else {
                return hasPathSum(sum, node.right, targetSum);
            }
        }
    }
}
