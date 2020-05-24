package LeetCode;

/**
 * 题目：机器人的运动范围
 */

public class Solution24 {
    public int movingCount(int m, int n, int k) {
        boolean[][] judge =  new boolean[m][n];
        int result = hasPath(k, 0, 0, m, n, judge);
        return result;
    }
    public int hasPath(int k, int x, int y,int m, int n, boolean judge[][]){
        if (x >= 0 && y >= 0 && x < m && y < n && !judge[x][y]){
            int add_x = x / 10 + x / 100 + x % 10;
            int add_y = y / 10 + y / 100 + y % 10;
            if (add_x + add_y > k){
                judge[x][y] = false;
                return 0;
            } else {
                judge[x][y] = true;
                return hasPath(k, x - 1, y, m, n, judge) + hasPath(k, x + 1, y, m, n, judge) + hasPath(k, x, y - 1, m, n, judge) + hasPath(k, x, y + 1, m, n, judge) + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int k = 1;
        System.out.println(new Solution24().movingCount(m, n, k));
    }
}
