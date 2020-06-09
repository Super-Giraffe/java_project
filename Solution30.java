package LeetCode;

/**
 * 题目：把数字翻译成字符串
 * 有一个不明白的点：就是0和一个数字组合成的数不能当作一个两位数处理
 * 比如506，结果是能是fag一种情况，但是fg这种不行
 * 所以在两位数判定是条件是 9 < num < 26
 */

public class Solution30 {
    public int translateNum(int num) {
        int res = 0;
        String str = Integer.toString(num);
        char[] c = str.toCharArray();
        res = isWord(c, 0, false) + isWord(c, 0, true);
        return res;
    }
    public int isWord(char[] num, int start, boolean len){
        if (len){
            if (start + 1 > num.length - 1){
                return 0;
            }
            int a = (num[start] - '0') * 10 + (num[start + 1] - '0');
            if (a < 26 && a > 9){
                if (start + 1 == num.length - 1){
                    return 1;
                } else {
                    return isWord(num, start + 2, false) + isWord(num, start + 2, true);
                }
            } else {
                return 0;
            }
        } else {
            if (start > num.length - 1){
                return 0;
            }
            if (start == num.length - 1){
                return 1;
            }
            return isWord(num, start + 1, false) + isWord(num, start + 1, true);
        }
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(new Solution30().translateNum(num));
    }
}
/**
 * 官方解法
 * class Solution {
 *     public int translateNum(int num) {
 *         String src = String.valueOf(num);
 *         int p = 0, q = 0, r = 1;
 *         for (int i = 0; i < src.length(); ++i) {
 *             p = q;
 *             q = r;
 *             r = 0;
 *             r += q;
 *             if (i == 0) {
 *                 continue;
 *             }
 *             String pre = src.substring(i - 1, i + 1);
 *             if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
 *                 r += p;
 *             }
 *         }
 *         return r;
 *     }
 * }
 */
