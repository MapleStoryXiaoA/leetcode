package leetcode.editor.cn;

public class P121买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{2, 4, 1}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int minIndex = 0;
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < prices[minIndex]) {
                    minIndex = i;
                }
                maxProfit = Math.max(maxProfit, prices[i] - prices[minIndex]);
            }
            return maxProfit;
        }
    }
}

