package leetcode.editor.cn;

import java.util.Arrays;

public class 排序_选择排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 15, 5, 36, 6, 35, 7};
        px(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void px(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j]<min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
