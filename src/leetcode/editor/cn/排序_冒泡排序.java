package leetcode.editor.cn;

import java.util.Arrays;

public class 排序_冒泡排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 15, 5, 35, 6, 36, 7};
        px(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void px(int[] arr) {
        for (int max = arr.length - 1; max >= 0; max--) {
            for (int i = 0; i < max; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
