package leetcode.editor.cn;

import java.util.HashMap;

/**
 * m <=  2的30次方
 */
public class 比正整数m大的最近的一个2的n次幂 {

    public static void main(String[] args) {
        int m = 5;
        System.out.println(new Solution1().get(m));
        System.out.println(new Solution2().get(m));
    }

    /**
     * 用java api转换为2进制,判断最高位
     */
    static class Solution1 {
        public int get(int m) {
            if (m <= 0) {
                return 0;
            }
            String binaryString = Integer.toBinaryString(m);
            if (binaryString.substring(1, binaryString.length()).contains("1")) {
                StringBuilder stringBuilder = new StringBuilder("1");
                for (int i = 0; i < binaryString.length(); i++) {
                    stringBuilder.append("0");
                }
                return Integer.valueOf(stringBuilder.toString(), 2);
            }
            return m;

        }
    }

    static class Solution2 {
        public int get(int m) {
            int n = m - 1;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            return n + 1;
        }
    }

}
