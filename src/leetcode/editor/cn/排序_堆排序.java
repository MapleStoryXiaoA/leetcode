package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思想:
 * 1. 数组是可以和完全二叉树相互转换的,从上至下,从左至右
 * 2. 完全二叉树满足父节点比子节点大时,就是一个大顶堆
 * 特性:
 * 1. 完全二叉树某个节点的索引为i, 则这个节点的父节点为(i-1)/2
 * 2. 完全二叉树某个节点的索引为i, 则左子节点为2i+1, 右子节点为2i+2
 * 步骤:
 * 1. 用数组构建最小堆
 * 2. 堆首尾交换,截取尾,重新堆化,循环此步骤
 */
public class 排序_堆排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        buildMinHeap(arr);
        getArr(arr);
    }

    //heapify操作,将某个节点设置为该节点为根的树中的最小值
    static void heapify(int[] tree, int length, int nodeIndex) {
        //左子节点
        int leftIndex = nodeIndex * 2 + 1;
        //右子节点
        int rightIndex = nodeIndex * 2 + 2;
        if (leftIndex > length - 1) {
            return;
        }
        if (rightIndex > length - 1) {
            if (tree[nodeIndex] > tree[leftIndex]) {
                swap(tree, nodeIndex, leftIndex);
            }
        } else {
            if (tree[leftIndex] <= tree[rightIndex] && tree[nodeIndex] > tree[leftIndex]) {
                swap(tree, nodeIndex, leftIndex);
                heapify(tree, length, leftIndex);
            } else if (tree[rightIndex] <= tree[leftIndex] && tree[nodeIndex] > tree[rightIndex]) {
                swap(tree, nodeIndex, rightIndex);
                heapify(tree, length, rightIndex);
            }
        }
    }

    //将数组构建最小堆
    static void buildMinHeap(int[] arr) {
        int lastNodeIndex = arr.length - 1;
        int lastNodeParentIndex = (lastNodeIndex - 1) / 2;
        for (int i = lastNodeParentIndex; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    //在最小堆中取出最小值
    static void getArr(int[] tree) {
        getArr(tree, tree.length);
    }

    private static void getArr(int[] tree, int length) {
        if (length == 1) {
            return;
        }
        swap(tree, 0, length - 1);
        heapify(tree, length - 1, 0);
        getArr(tree, length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
