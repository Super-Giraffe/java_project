package LeetCode;

/**
 * 题目：不同的路径II
 */
public class Solution45 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid == null){
            return 0;
        }
        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
        int flag = 0;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (flag == 1){
                res[0][i] = 0;
            } else {
                if (obstacleGrid[0][i] == 1){
                    flag = 1;
                    res[0][i] = 0;
                } else {
                    res[0][i] = 1;
                }
            }
        }
        flag = 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (flag == 1){
                res[i][0] = 0;
            } else {
                if (obstacleGrid[i][0] == 1){
                    flag = 1;
                    res[i][0] = 0;
                } else {
                    res[i][0] = 1;
                }
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++){
            for (int j = 1; j < obstacleGrid[0].length; j++){
                if (obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
