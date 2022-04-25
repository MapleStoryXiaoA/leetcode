package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Random;

public class 剑指OfferII071按权重生成随机数 {

    public static void main(String[] args) {
        int[] ints = {};
        Solution solution = new Solution(ints);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int anInt : ints) {
            map.put(anInt, 0);
        }
        for (int i = 0; i < 100000; i++) {
            int res = solution.pickIndex();
            map.put(res, map.get(res) + 1);
        }
        System.out.println(map);
    }

    static class Solution {

        private int[] w;

        public Solution(int[] w) {
            this.w = w;
        }

        public int pickIndex() {
            int sum = sum();
            Random random = new Random();
            int basic = random.nextInt(sum);
            for (int i = 0; i < w.length - 1; i++) {
                basic = basic - w[i];
                if (basic < 0) {
                    return i;
                }
            }
            return w.length - 1;
        }

        public int sum() {
            int res = 0;
            for (int i : w) {
                res += i;
            }
            return res;
        }
    }
}