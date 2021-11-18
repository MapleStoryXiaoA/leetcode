package leetcode.editor.cn;

/**
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P69SqrtX求算数平方根 {

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(8));
    }

    //二分查找法
    //说明:使二分查找的左边界设为1,有边界设置为x/2,则只有(x/2)^2<4这种情况为特殊情况要单独处理
    static class Solution {
        public int mySqrt(int x) {
            if (x == 0){
                return 0;
            }
            if (x == 1 || x == 2 || x == 3) {
                return 1;
            }


            int left = 0;
            int right = x;
            int res = 0;
            while (left < right) {

                int middle = (right + left) / 2;

                if ((long)middle * middle > x) {
                    right = middle;
                }
                if (middle * middle == x) {
                    return middle;
                }
                if ((long)middle * middle < x) {
                    res = middle;
                    left = middle + 1;

                }
            }
            return res;
        }
    }
}
