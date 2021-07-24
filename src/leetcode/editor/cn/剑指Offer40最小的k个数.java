package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 剑指Offer40最小的k个数 {
    public static void main(String[] args) {

    }

    static class Solution1 {
        public int[] getLeastNumbers(int[] arr, int k) {
            MinHeap<Integer> minHeap = new MinHeap<>();
            for (int i : arr) {
                minHeap.addLast(i);
            }

            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = minHeap.removeMax();
            }
            return res;
        }

        private static class MinHeap<E extends Comparable<E>> {


            private ArrayList<E> data;

            public MinHeap(int capacity) {
                data = new ArrayList<>(capacity);
            }

            public MinHeap() {
                data = new ArrayList<>();
            }

            //传入一个节点的索引,找到父节点的索引
            private int getParentIndex(int index) {
                if (index <= 0) {
                    throw new IllegalArgumentException("错误的索引");
                }
                //完全二叉树性质:完全二叉树可以用数组来表示,父节点的索引为子节点减1再除2
                return (index - 1) / 2;
            }

            //传入一个节点的索引,找到左子节点的索引
            private int getLeftIndex(int index) {
                return index * 2 + 1;
            }

            //传入一个节点的索引,找到左子节点的索引
            private int getRightIndex(int index) {
                return index * 2 + 2;
            }

            //向堆中添加元素
            public void addLast(E e) {
                //添加到最后一个节点
                data.add(e);
                //调整符合最大堆
                siftUp(data.size() - 1);
            }

            //将哪个索引上浮,比较并交换
            private void siftUp(int index) {
                //如果该节点的父节点小于这个节点,则交换
                while (index > 0 && data.get(getParentIndex(index)).compareTo(data.get(index)) > 0) {
                    int parentIndex = getParentIndex(index);
                    swap(data, index, parentIndex);
                    //重置下次循环的起点
                    index = parentIndex;
                }
            }

            //交换
            private void swap(List<E> list, int index1, int index2) {
                E e1 = list.get(index1);
                E e2 = list.get(index2);
                list.set(index1, e2);
                list.set(index2, e1);
            }

            //看一下堆中最小的元素
            public E getMax() {
                if (data.size() == 0) {
                    return null;
                }
                return data.get(0);
            }

            //取出堆中最小的元素
            public E removeMax() {
                E max = getMax();
                if (max == null) {
                    return null;
                }
                //堆的顶点和最后一个节点互换
                swap(data, 0, data.size() - 1);
                //删除最后一个节点
                data.remove(data.size() - 1);
                //顶点下沉
                sickDown(0);
                return max;
            }

            //下沉,比较并互换子节点中较大的节点
            private void sickDown(int index) {
                //如果当前节点的逻辑左孩子索引越界,代表没有左孩子,则跳出循环
                while (getLeftIndex(index) < data.size()) {
                    int leftIndex = getLeftIndex(index);
                    int rightIndex = getRightIndex(index);

                    int biggerIndex = leftIndex;
                    //如果该节点有右孩子
                    if (rightIndex < data.size()) {
                        //找出左右孩子谁大
                        if (data.get(rightIndex).compareTo(data.get(leftIndex)) < 0) {
                            biggerIndex = rightIndex;
                        }
                    }
                    //如果父比子小就交换
                    if (data.get(index).compareTo(data.get(biggerIndex)) <= 0) {
                        break;
                    }
                    swap(data, index, biggerIndex);
                    //重置下次循环的起点
                    index = biggerIndex;
                }
            }

        }
    }

    static class Solution2 {
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i : arr) {
                queue.add(i);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll();
            }
            return res;
        }
    }
}
