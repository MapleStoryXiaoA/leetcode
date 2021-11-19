package leetcode.editor.cn;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class P110是否平衡二叉树 {
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

    //自顶向下
    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root==null){
                return true;
            }
            if (Math.abs(height(root.left) - height(root.right))<2){
                if (isBalanced(root.left)){
                    return isBalanced(root.right);
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }

        private int height(TreeNode node) {
            if (node==null){
                return 0;
            }
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }


    //自底向上
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        private int height(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            if (leftHeight == -1 || rightHeight == -1) {
                return -1;
            } else {
                if (Math.abs(leftHeight - rightHeight) > 1) {
                    return -1;
                } else {
                    return Math.max(leftHeight, rightHeight) + 1;
                }
            }
        }
    }
}
