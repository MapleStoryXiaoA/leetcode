package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P145二叉树的后序遍历 {

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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postorderTraversal(res, root);
            return res;
        }

        public void postorderTraversal(List<Integer> res, TreeNode node) {
            if (node == null) {
                return;
            }
            postorderTraversal(res, node.left);
            postorderTraversal(res, node.right);
            res.add(node.val);
        }
    }
}
