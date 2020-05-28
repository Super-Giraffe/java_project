package LeetCode;

/**
 * 链表中倒数第k个节点
 * 特殊点：1.整个列表为空 2.k等于0 3.链表的节点数小于k
 */

public class Solution02 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode flag = head;
        int len = 0;
        while(flag != null){
            flag = flag.next;
            len++;
        }
        for(int i = 0; i < len - k; i++){
            head = head.next;
        }
        return head;
    }
}
