package leetcode.editor.cn;

/**
 * 线段树:
 * 固定数组实现
 * 将线段抽象成树最坏情况下需要4倍空间
 * 线段树想象成满二叉树
 */
public class SegmentTree线段树 {
    public static void main(String[] args) {
        Integer[] arr = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> tree = new SegmentTree<>(arr, Integer::sum);
        System.out.println(tree.get(0));
        System.out.println(tree.get(0, 5));
        tree.update(1, 1);
        System.out.println(tree.get(0, 5));
    }

    interface Merger<E> {
        E merge(E a, E b);
    }

    static class SegmentTree<E> {
        private E[] data;
        private E[] tree;
        private Merger<E> merger;


        public SegmentTree(E[] arr, Merger<E> merger) {

            this.merger = merger;

            this.data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }

            tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, data.length - 1);
        }


        /**
         * 递归构建线段树,父节点由左节点在数组中的索引一直聚合到右节点
         *
         * @param parent 父节点索引
         * @param left   左节点之于数组索引
         * @param right  数组中的之于数组索引
         */
        private void buildSegmentTree(int parent, int left, int right) {
            //如果线段树不可划分
            if (left == right) {
                tree[parent] = data[left];
                return;
            }

            int leftTreeIndex = getLeftIndex(parent);
            int rightTreeIndex = getRightIndex(parent);
            int mid = left + (right - left) / 2;
            buildSegmentTree(leftTreeIndex, left, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, right);
            tree[parent] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }


        public int size() {
            return data.length;
        }

        public E get(int index) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("index error");
            }
            return tree[index];
        }

        //查前闭后闭的区间的聚合
        public E get(int queryLeft, int queryRight) {
            if (queryLeft < 0
                    || queryLeft >= data.length
                    || queryRight < 0
                    || queryRight >= data.length
                    || queryRight < queryLeft
            ) {
                throw new IllegalArgumentException("index error");
            }
            return get(0, 0, data.length - 1, queryLeft, queryRight);
        }

        /**
         * @param treeIndex  树的节点
         * @param dataLeft   数据范围左界
         * @param dataRight  数据范围右界
         * @param queryLeft  查找目标左界
         * @param queryRight 查找目标右界
         * @return 查找范围聚合值
         */
        private E get(int treeIndex, int dataLeft, int dataRight, int queryLeft, int queryRight) {
            if (dataLeft == queryLeft && dataRight == queryRight) {
                return tree[treeIndex];
            }

            int mid = dataLeft + (dataRight - dataLeft) / 2;
            int leftTreeIndex = getLeftIndex(treeIndex);
            int rightTreeIndex = getRightIndex(treeIndex);

            if (queryLeft > mid + 1) {
                return get(rightTreeIndex, mid + 1, dataRight, queryLeft, queryRight);
            }
            if (queryRight <= mid) {
                return get(leftTreeIndex, dataLeft, mid, queryLeft, queryRight);
            }

            return merger.merge(get(leftTreeIndex, dataLeft, mid, queryLeft, mid),
                    get(rightTreeIndex, mid + 1, dataRight, mid + 1, queryRight));
        }

        //传入一个节点的索引,找到左子节点的索引
        private int getLeftIndex(int index) {
            return index * 2 + 1;
        }

        //传入一个节点的索引,找到左子节点的索引
        private int getRightIndex(int index) {
            return index * 2 + 2;
        }

        //更新
        public void update(int index, E e) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("index error");
            }
            data[index] = e;
            update(0, 0, data.length - 1, index, e);
        }

        private void update(int treeIndex, int left, int right, int index, E e) {
            if (left == right) {
                tree[treeIndex] = e;
                return;
            }

            //递归最深找到改变的那个叶子节点
            int mid = left + (right - left) / 2;
            int leftTreeIndex = getLeftIndex(treeIndex);
            int rightTreeIndex = getRightIndex(treeIndex);
            if (index >= mid + 1) {
                update(rightTreeIndex, mid + 1, right, index, e);
            } else {
                update(leftTreeIndex, left, mid, index, e);
            }

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }
    }
}
