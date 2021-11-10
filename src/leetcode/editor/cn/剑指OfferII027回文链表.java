package leetcode.editor.cn;

/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * <p>
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 */
public class 剑指OfferII027回文链表 {


    //方法一:遍历一遍放入数组为O(n)的时间,再用数组下标来比较值,此处用到内存寻址为O(1)的时间
    class Solution1 {

    }

    //方法二:递归比较

    //方法三:快慢指针,翻转后半链表,用后半链表与前半链表比较,再复原链表
    class Solution3 {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode quick = head;
            while (quick != null && quick.next != null && quick.next.next == null) {
                slow = slow.next;
                quick = quick.next.next;
            }
            ListNode reverseHead = reverse(slow);
            while (reverseHead != null && head != null) {
                if (reverseHead.val != head.val) {
                    return false;
                }
                reverseHead = reverseHead.next;
                head = head.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
