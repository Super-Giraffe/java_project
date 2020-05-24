package LeetCode;

//题目：斐波那契数列

public class Solution19 {
    public int fib(int n) {
        int[] num = new int[n + 1];
        if (n == 0){
            return 0;
        }else {
            num[0] = 0;
            num[1] = 1;
            for (int i = 2; i < num.length; i++) {
                num[i] = (num[i - 1] + num[i - 2]) % 1000000007;
            }
            return num[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution19().fib(5));;
    }
}
