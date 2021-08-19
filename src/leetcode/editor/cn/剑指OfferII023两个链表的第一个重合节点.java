package leetcode.editor.cn;

/**
 * 给定两个单链表的头节点 headA 和 headB ，
 * 请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3u1WK4
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 剑指OfferII023两个链表的第一个重合节点 {
    public static void main(String[] args) {
        System.out.println((null == null));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 做法: 双指针遍历
     * 思路: 先遍历a再遍历b 和 先遍历b再遍历a 这两种遍历方式,
     *      1. 首先,a+b和b+a的长度肯定一样
     *      2. 如果a和b有相同的部分,那么双指针在后段一定有一段是重复的, 第一个重复的节点就是相交点
     *      3. 如果没有相同的部分,最后都会遍历为null
     */
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode abListNode = headA;
            ListNode baListNode = headB;
            while (abListNode != baListNode) {
                abListNode = abListNode == null ? headB : abListNode.next;
                baListNode = baListNode == null ? headA : baListNode.next;
            }
            return abListNode;
        }
    }
}
