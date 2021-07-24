package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P215数组中的第K个最大元素 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int res = solution.findKthLargest(new int[]{2, 100, 22222, 323424, 11, 2, 1}, 2);
        System.out.println(res);
    }

    //自己实现一个最大堆
    static class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            MaxHeap<Integer> heap = new MaxHeap<>();
            for (int num : nums) {
                heap.addLast(num);
            }
            for (int i = 0; i < k; i++) {
                Integer res = heap.removeMax();
                if (i == k - 1) {
                    return res;
                }
            }
            return -1;
        }

        private static class MaxHeap<E extends Comparable<E>> {


            private ArrayList<E> data;

            public MaxHeap(int capacity) {
                data = new ArrayList<>(capacity);
            }

            public MaxHeap() {
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
                while (index > 0 && data.get(getParentIndex(index)).compareTo(data.get(index)) < 0) {
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

            //看一下堆中最大的元素
            public E getMax() {
                if (data.size() == 0) {
                    return null;
                }
                return data.get(0);
            }

            //取出堆中最大的元素
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
                        if (data.get(rightIndex).compareTo(data.get(leftIndex)) > 0) {
                            biggerIndex = rightIndex;
                        }
                    }
                    //如果父比子小就交换
                    if (data.get(index).compareTo(data.get(biggerIndex)) >= 0) {
                        break;
                    }
                    swap(data, index, biggerIndex);
                    //重置下次循环的起点
                    index = biggerIndex;
                }
            }

        }
    }

    //使用java实现的优先队列(最小堆)
    static class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            //最小堆
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                //如果堆中还没有满到k个值
                if (queue.size() < k) {
                    queue.add(num);
                }
                //如果堆中的数据已经到k值
                else {
                    //比较堆的最小值
                    Integer min = queue.peek();
                    if (num > min) {
                        queue.poll();
                        queue.add(num);
                    }
                }
            }
            return queue.peek();
        }
    }
}
