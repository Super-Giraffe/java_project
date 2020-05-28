package LeetCode;

/**
 * 题目：合并两个排序的链表
 */

public class Solution03 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode result1 = null;
        if (l1 == null) {
            if (l2 == null) {
                return null;
            } else {
                return l2;
            }
        } else {
            if (l2 == null){
                return l1;
            }
            else {
                if (l1.val > l2.val){
                    result = l2;
                    result1 = l2;
                    l2 = l2.next;
                } else {
                    result = l1;
                    result1 = l1;
                    l1 = l1.next;
                }
                while (l1 != null && l2 != null){
                    if (l1.val > l2.val){
                        result1.next = l2;
                        l2 = l2.next;
                        result1 = result1.next;
                    } else {
                        result1.next = l1;
                        l1 = l1.next;
                        result1 = result1.next;
                    }
                }
                if (l1 != null){
                    result1.next = l1;
                }
                if (l2 != null){
                    result1.next = l2;
                }
            }
        }
        return result;
    }
}
