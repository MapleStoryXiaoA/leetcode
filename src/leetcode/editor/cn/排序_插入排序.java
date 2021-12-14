package leetcode.editor.cn;

import java.util.Arrays;

public class 排序_插入排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 15, 5, 36, 6, 35, 7};
        px(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void px(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i + 1;
            int temp = arr[index];
            for (int j = i; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = temp;
                    break;
                }
            }
        }
    }
}
