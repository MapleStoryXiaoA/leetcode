package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * 1.是一个二叉树
 * 2.根节点只有一个
 * 3.每个节点大于左子节点,小于右子节点
 * 4.不包含重复元素
 */

public class BST二分搜索树 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(3);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);


        System.out.println("该树含有3吗?" + bst.contains(3));


        System.out.println("深度优先遍历 ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓");
        System.out.println("前序递归遍历:");
        bst.preOrder();
        System.out.println("中序递归遍历:");
        bst.inOrder();
        System.out.println("后序递归遍历:");
        bst.postOrder();
        System.out.println("前序栈辅助遍历:");
        bst.preOrderNR();


        System.out.println("广度优先遍历 ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓");
        bst.levelOrder();

        System.out.println("删除最小值:");
        Integer integer = bst.removeMin();
        System.out.println("已经删除:" + integer);
        bst.levelOrder();

        System.out.println("删除4:");
        bst.remove(4);
        bst.levelOrder();
    }

    private static class BST<E extends Comparable<E>> {

        @Override
        public String toString() {
            return "BST{" +
                    "root=" + root +
                    ", size=" + size +
                    '}';
        }

        private class Node {
            public E e;
            public Node left, right;

            public Node(E e) {
                this.e = e;
                this.left = null;
                this.right = null;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "e=" + e +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
        }

        private Node root;
        private int size;

        public BST() {
            this.root = null;
            this.size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }


        //插入元素
        public void add(E e) {
            if (root == null) {
                root = new Node(e);
                size++;
            } else {
                add(root, e);
            }
        }

        //向node为根的二分搜索树中插入元素e,递归
        private void add(Node node, E e) {
            if (e.equals(node.e)) {
            } else if (e.compareTo(node.e) < 0) {
                if (node.left == null) {
                    node.left = new Node(e);
                    size++;
                } else {
                    add(node.left, e);
                }
            } else if (e.compareTo(node.e) > 0) {
                if (node.right == null) {
                    node.right = new Node(e);
                    size++;
                } else {
                    add(node.right, e);
                }
            }
        }

        //查询是否包含元素
        public boolean contains(E e) {
            return contains(root, e);
        }

        private boolean contains(Node node, E e) {
            if (node == null) {
                return false;
            }
            if (e.equals(node.e)) {
                return true;
            }

            if (e.compareTo(node.e) < 0) {
                return contains(node.left, e);
            } else {
                return contains(node.right, e);
            }
        }

        // 前序遍历
        // 使用递归
        public void preOrder() {
            preOrder(root);
        }

        private void preOrder(Node node) {
            if (node == null) {
                return;
            }
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }

        // 中序遍历
        // 特点结果为从小到大排序
        // 使用递归实现
        public void inOrder() {
            inOrder(root);
        }

        private void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }

        // 后序遍历
        // 应用:内存的释放
        // 使用递归
        public void postOrder() {
            postOrder(root);
        }

        private void postOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            inOrder(node.right);
            System.out.println(node.e);
        }

        // 前序遍历
        // 使用栈辅助遍历,每次右孩子先入栈
        public void preOrderNR() {
            Stack<Node> nodeStack = new Stack<>();
            nodeStack.push(root);
            while (!nodeStack.empty()) {
                Node parent = nodeStack.pop();
                System.out.println(parent.e);
                if (parent.right != null) {
                    nodeStack.push(parent.right);
                }
                if (parent.left != null) {
                    nodeStack.push(parent.left);
                }
            }
        }


        //层序遍历(广度优先遍历)
        //使用队列辅助,每次左孩子先入队
        //优点是查找某个值更快
        //应用是最小路径
        public void levelOrder() {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node parent = q.poll();
                System.out.println(parent.e);
                if (parent.left != null) {
                    q.add(parent.left);
                }
                if (parent.right != null) {
                    q.add(parent.right);
                }
            }
        }

        //寻找最小值
        public E queryMin() {
            if (size == 0) {
                return null;
            }
            return queryMin(root).e;
        }

        private Node queryMin(Node node) {
            if (node.left == null) {
                return node;
            } else {
                return queryMin(node.left);
            }
        }

        //删除最小值
        public E removeMin() {
            E res = queryMin();
            root = removeMin(root);
            return res;
        }

        private Node removeMin(Node node) {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            node.left = removeMin(node.left);
            return node;
        }

        //删除指定值
        public void remove(E e) {
            root = remove(root, e);
        }

        private Node remove(Node node, E e) {
            if (node == null) {
                return null;
            }
            if (e.compareTo(node.e) < 0) {
                node.left = remove(node.left, e);
                return node;
            } else if (e.compareTo(node.e) > 0) {
                node.right = remove(node.right, e);
                return node;
            } else {
                if (node.left == null) {
                    Node right = node.right;
                    node.right = null;
                    size--;
                    return right;
                }
                if (node.right == null) {
                    Node left = node.left;
                    node.left = null;
                    size--;
                    return left;
                }
                //如果左右子树均不为null
                Node successor = queryMin(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }

    }
}
