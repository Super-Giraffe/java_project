package LeetCode;

/**
 * 题目：剪绳子I
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 2 <= n <= 58
 */

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 题目：剪绳子II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 2 <= n <= 1000
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */

//剪绳子II中因为n扩大到1000，所以代码逻辑和I一样，只是把求最大值和求模写成大数的运算,但是这里用贪心算法解决

public class Solution22 {
    public int cuttingRope(int n) {
        /*if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int[] l = new int[n + 1];
        l[1] = 1;
        l[2] = 2;
        l[3] = 3;
        for (int i = 4; i <= n; i++) {
            l[i] = 0;
            for (int j = 1; j <= i / 2; j++){
                if (l[j] * l[i - j] > l[i]){
                    l[i] = l[j] * l[i - j];
                }
            }
        }
        return l[n];*/
        //贪心算法
        if(n<=3) return n-1;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    public static void main(String[] args) {
        int len = new Solution22().cuttingRope(10);
        System.out.println(len);
    }
}
