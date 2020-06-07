package LeetCode;

/**
 * 题目：两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */

public class Solution17 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode res = l3;
        int c = 0;
        while (true){
            if (l1 == null){
                l3.val = (l2.val + c) % 10 ;
                c = (l2.val + c) / 10;
                l2 = l2.next;
            } else {
                if (l2 == null){
                    l3.val = (l1.val + c) % 10 ;
                    c = (l1.val + c) / 10;
                    l1 = l1.next;
                } else {
                    l3.val = (l1.val + l2.val + c) % 10 ;
                    c = (l1.val + l2.val + c) / 10;
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            if (l1 == null && l2 == null){
                break;
            } else {
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
        }
        if (c == 1){
            l3.next = new ListNode(1);
        }
        return res;
    }
}
