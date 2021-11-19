package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P94二叉树的中序遍历 {

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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorderTraversal(res, root);
            return res;
        }

        public void inorderTraversal(List<Integer> res, TreeNode node) {
            if (node == null) {
                return;
            }
            inorderTraversal(res, node.left);
            res.add(node.val);
            inorderTraversal(res, node.right);
        }
    }
}
