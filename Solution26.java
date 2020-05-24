package LeetCode;

//题目：删除链表的节点

public class Solution26 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode flag1 = head;
        ListNode flag2 = head;
        if (head.val == val) {
            return head.next;
        } else {
            while (flag1 != null && flag1.val != val){
                flag2 = flag1;
                flag1 = flag1.next;
            }
        }
        if (flag1 != null){
            flag2.next = flag1.next;
        }
        return head;
    }
}
