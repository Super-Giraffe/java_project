package LeetCode;

/**
 * 题目：数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 解决思路：使用快速幂（二分思想）

 */

public class Solution25 {
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        double res = 1.0;
        long b = n;
        if(b < 0){
            x = 1 / x;
            b = -b;
        }
        while(b > 0){
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
