package leetcode.editor.cn;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P58最后一个单词的长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("hello "));
    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            int lastLetterIndex = -1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (Character.isLetter(s.charAt(i))) {
                    lastLetterIndex = i;
                    break;
                }
            }
            if (lastLetterIndex == -1) {
                return 0;
            }

            for (int i = lastLetterIndex; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    return lastLetterIndex - i;
                }
            }
            return lastLetterIndex+1;
        }
    }
}
