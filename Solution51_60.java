package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class Solution51_60 {
    public static void main(String[] args){
        
    }
}

//删除链表倒数第n个节点
class Solution51{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        for (ListNode node = head; node != null; node = node.next){
            length++;
        }
        ListNode node = head;
        for (int i = 0; i < length - n - 1; i++){
            node = node.next;
        }
        if (n == length){
            return head.next;
        } else {
            ListNode pre = node;
            ListNode cur = node.next;
            ListNode next = cur.next;
            pre.next = next;
            cur.next = null;
            return head;
        }
    }
    public ListNode advanced(ListNode head, int n) {    //只遍历一次链表
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode flag = node;
        for (int i = 0; i < n + 1; i++){
            flag = flag.next;
        }
        ListNode pre = node;
        while (flag != null){
            pre = pre.next;
            flag = flag.next;
        }
        pre.next = pre.next.next;
        return node.next;
    }
}

//整数拆分
class Solution52{
    public int integerBreak(int n) {
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        for (int i = 4; i <= n; i++){
            nums[i] = i;
            for (int j = 1; j <= i / 2; j++){
                if (nums[j] * nums[i - j] > nums[i]){
                    nums[i] = nums[j] * nums[i - j];
                }
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        int res = new Solution52().integerBreak(10);
        System.out.println(res);
    }
}

//合并两个有序链表
class Solution53{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode flag = head;
        while (l1 != null && l2 != null){
            ListNode node;
            if (l2.val < l1.val){
                node = new ListNode(l2.val);
                flag.next = node;
                flag = flag.next;
                l2 = l2.next;
            } else {
                node = new ListNode(l1.val);
                flag.next = node;
                flag = flag.next;
                l1 = l1.next;
            }
        }
        if (l1 == null){
            flag.next = l2;
        } else {
            if (l2 == null){
                flag.next = l1;
            }
        }
        return head.next;
    }
}

//两两交换链表中的节点
class Solution54{
    public ListNode swapPairs(ListNode head) {
        ListNode guard = new ListNode(0);
        ListNode flag = guard;
        flag.next = head;
        ListNode cur;
        ListNode next;
        while ((cur = flag.next) != null && (next = flag.next.next) != null){
            cur.next = next.next;
            next.next = cur;
            flag.next = next;
            flag = cur;
        }
        return guard.next;
    }
}

//删除排序数组中的重复项
class Solution55{
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return  i + 1;
        /*int flag = nums[0];
        int count = 0;
        for (int i = 1, k = 1; i < nums.length && k < nums.length; k++){
            if (flag == nums[i]){
                for (int j = i + 1; j < nums.length; j++){
                    nums[j - 1] = nums[j];
                }
            } else {
                flag = nums[i];
                count++;
                i++;
            }
        }
        return count + 1;*/
    }
}

//实现strStr()
class Solution56{
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if (needle.length() == 0 || needle == null){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++){
            if (haystack.substring(i, i + len).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

//二叉树展开为链表
class Solution57{
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        search(root, list);
        for (int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i).left = null;
        }
    }
    public void search(TreeNode node, List<TreeNode> list){
        if (node != null){
            list.add(node);
            search(node.left, list);
            search(node.right, list);
        }
    }
}

//字符串相加
class Solution58{
    public String addStrings(String num1, String num2) {
        int i, j;
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        char[] res = new char[Math.max(c1.length, c2.length)];
        int len = res.length - 1;
        int c0 = 0;
        for (i = c1.length - 1, j = c2.length - 1; i >= 0 || j >= 0; i--, j--){
            int num = 0;
            if (i < 0){
                num = (c2[j] - '0' + c0) % 10;
                c0 = (c2[j] - '0' + c0) / 10;
            } else {
                if (j < 0){
                    num = (c1[i] - '0' + c0) % 10;
                    c0 = (c1[i] - '0' + c0) / 10;
                } else {
                    num = (c1[i] - '0' + c2[j] - '0' + c0) % 10;
                    c0 = (c1[i] - '0' + c2[j] - '0' + c0) / 10;
                }
            }
            res[len--] = (char)(num + '0');
        }
        if (c0 == 1){
            return "1" + new String(res);
        }
        return new String(res);
    }
}

//课程表
class Solution59{
    List<List<Integer>> list = new ArrayList<>();
    boolean res = true;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for (int[] i : prerequisites){
            list.get(i[1]).add(i[0]);
        }
        for (int j = 0; j < numCourses && res; j++){
            if (visited[j] == 0){
                dfs(j);
            }
        }
        return true;
    }

    public void dfs(int u){
        visited[u] = 1;
        for (int k : list.get(u)){
            if (visited[k] == 0){
                dfs(k);
            } else {
                if (visited[k] == 1){
                    res = false;
                    return;
                }
            }
        }
        visited[u] = 2;
    }
}

//在排序数组中查找元素的第一个和最后一个位置
class Solution60{
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIdx = extremeInsertionIndex(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }
}