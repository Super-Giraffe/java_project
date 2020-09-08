package LeetCode;

import com.sun.source.tree.Tree;

import java.util.*;

public class Solution71_80 {
    public static void main(String[] args) {
        String res = new Solution78().getPermutation(4,6);
        System.out.println(res);
    }
}

//扫雷游戏
class Solution71 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int count = 0;
        char c = board[click[0]][click[1]];
        switch (c){
            case 'M':
                board[click[0]][click[1]] = 'X';
                break;
            case 'E':
                for (int i = click[0] - 1; i < click[0] + 2; i++){
                    if (i < 0 || i > board.length - 1){
                        continue;
                    }
                    for (int j = click[1] - 1; j < click[1] + 2; j++){
                        if (j < 0 || j > board[0].length - 1){
                            continue;
                        }
                        if (board[i][j] == 'M'){
                            count++;
                        }
                    }
                }
                if (count != 0){
                    board[click[0]][click[1]] = (char)(count + '0');
                } else {
                    board[click[0]][click[1]] = 'B';
                    for (int i = click[0] - 1; i < click[0] + 2; i++){
                        for (int j = click[1] - 1; j < click[1] + 2; j++){
                            if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'E'){
                                continue;
                            }
                            updateBoard(board, new int[]{i, j});
                        }
                    }
                }
                break;
        }
        return board;
    }
}

//二叉树最小深度
class Solution72{
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}

//
class Solution73{
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for (int i = m + 1; i <= n; i++){
            res &= i;
        }
        return res;
    }
}

/**
 * 题目：重复的子字符串
 * 因为题目中已说明至少存在一种合理的行程，所以整个图中最多存在一处死胡同(入度与出度的差为1)，并且该死胡同一定是最后一个节点
 * 对于当前节点而言，从它的每一个非「死胡同」分支出发进行深度优先搜索，都将会搜回到当前节点。
 * 而从它的「死胡同」分支出发进行深度优先搜索将不会搜回到当前节点。
 * 也就是说当前节点的死胡同分支将会优先于其他非「死胡同」分支入栈
 * 最后通过反转可以得到一条正确的行程路径
 */
class Solution74{
    public boolean repeatedSubstringPattern(String s) {
        char[] c = s.toCharArray();
        for (int i = 1; i < c.length; i++){
            if (c[i] == c[0]){
                String flag = s.substring(0, i);
                int len = flag.length();
                int j;
                boolean res = true;
                for (j = i; j + len <= s.length(); j += len){
                    if (!flag.equals(s.substring(j, j + len))){
                        res = false;
                        break;
                    }
                }
                if (j == s.length() && res){
                    return true;
                }
            }
        }
        return false;
    }
}

//递增子序列
class Solution75{
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}

//重新安排行程
class Solution76{
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }
}

//反转中的字符串III
class Solution77{
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String res = "";
        int i;
        for (i = 0; i < words.length - 1; i++){
            words[i] = new StringBuilder(words[i]).reverse().toString();
            res += words[i] + " ";
        }
        res += new StringBuilder(words[i]).reverse().toString();
        return res;
    }
}

//第k个排列
class Solution78{
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        //将1~n的阶乘存入到数组中
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }
        --k;
        StringBuffer ans = new StringBuffer();
        //该数组用于记录1~n各数的使用情况，1为未使用，0为已使用
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}

//二叉树的层次遍历II
class Solution79{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        DFS(root, 0);
        Collections.reverse(res);
        return res;
    }
    public void DFS(TreeNode node, int num){
        if (node == null){
            return;
        }
        if (res.size() < num + 1){
            List<Integer> flag = new ArrayList<>();
            res.add(flag);
        }
        if (node.left != null || node.right != null){
            DFS(node.left, num + 1);
            DFS(node.right, num + 1);
        }
        res.get(num).add(node.val);
    }
}

//前K个高频元素
class Solution80{
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        int[] counts = new int[occurrences.size()];
        int[] numbers = new int[occurrences.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            counts[i] = count;
            numbers[i] = num;
            i++;
        }
        quick_sort(counts, numbers, 0, counts.length - 1);
        int[] res = new int[k];
        for (int j = 0 ; j < k; j++){
            res[j] = numbers[numbers.length - 1 - j];
        }
        return res;
    }
    public static void quick_sort(int[] array1, int[] array2,int start, int end){
        if (start > end){
            return ;
        }
        int i = start;
        int j = end;
        int temp1 = array1[start];
        int temp2 = array2[start];
        while (i < j){
            while (array1[j] >= temp1 && i < j){
                j--;
            }
            while (array1[i] <= temp1 && i < j){
                i++;
            }
            if (i < j){
                int t = array1[i];
                array1[i] = array1[j];
                array1[j] = t;
                int k = array2[i];
                array2[i] = array2[j];
                array2[j] = k;
            }
        }
        array1[start] = array1[i];
        array1[i] = temp1;
        array2[start] = array2[i];
        array2[i] = temp2;
        quick_sort(array1, array2, start, i - 1);
        quick_sort(array1, array2,i + 1, end);
    }
}