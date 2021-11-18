package leetcode.editor.cn;

public class P67二进制求和 {

    public static void main(String[] args) {

    }

    class Solution {
        public String addBinary(String a, String b) {

            StringBuffer ans = new StringBuffer();

            int lenA = a.length(), lenB = b.length();
            int maxLen = Math.max(lenA, lenB);

            int carry = 0;
            for(int i = maxLen - 1; i >= 0; i--){

                if(lenA-- > 0) carry += a.charAt(lenA) - '0';
                if(lenB-- > 0) carry += b.charAt(lenB) - '0';

                ans.append(carry % 2);
                carry /= 2;
            }
            if(carry == 1) ans.append(carry);

            return ans.reverse().toString();
        }
    }
}
