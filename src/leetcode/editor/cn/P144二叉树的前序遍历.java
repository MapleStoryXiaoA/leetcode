package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class P144二叉树的前序遍历 {

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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preorderTraversal(res, root);
            return res;
        }

        public void preorderTraversal(List<Integer> res, TreeNode node) {
            if (node == null) {
                return;
            }
            res.add(node.val);
            preorderTraversal(res, node.left);
            preorderTraversal(res, node.right);
        }
    }
}
