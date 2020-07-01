package LeetCode;

/**
 * 题目：最长重复子数组
 */
public class Solution42 {
    public int findLength(int[] A, int[] B) {
        //动态规划
        int res = 0;
        int[][] flag = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (A[i] == B[j]){
                    if(i > 0 && j > 0){
                        flag[i][j] = flag[i - 1][j - 1] + 1;
                    } else {
                        flag[i][j] = 1;
                    }
                } else {
                    flag[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (flag[i][j] > res){
                    res = flag[i][j];
                }
            }
        }
        return res;
        /*暴力扫描
        int res = 0;
        int len = 0;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (A[i] == B[j]){
                    int x = i;
                    int y = j;
                    for (;x < A.length && y < B.length; x++, y++){
                        if (A[x] == B[y]){
                            len++;
                        } else {
                            break;
                        }
                    }
                    if (res < len){
                        res = len;
                    }
                    len = 0;
                }
            }
        }
        return res;*/
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        System.out.println(new Solution42().findLength(A, B));
    }
}
