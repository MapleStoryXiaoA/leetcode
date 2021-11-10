package leetcode.editor.cn;

public class 剑指OfferII024反转链表 {

    public static void main(String[] args) {

    }

    //遍历
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while (cur != null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }

    //递归
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head==null || head.next==null){
                return head;
            }
            ListNode res = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return res;
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

