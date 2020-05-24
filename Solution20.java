package LeetCode;

//题目：青蛙跳台阶问题（动态规划）

public class Solution20 {
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        int result = new Solution20().numWays(43);
        System.out.println(result);
    }
}
