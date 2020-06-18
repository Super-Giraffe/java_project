package LeetCode;

/**
 * 最长回文子串(动态规划)
 */

public class Solution33 {
    public String longestPalindrome(String s) {
        if (s.length() == 0){
            return "";
        }
        boolean[][] judge = new boolean[s.length()][s.length()];
        char[] c = s.toCharArray();
        String res = "";
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j + i < s.length(); j++){
                if (i == 0){
                    judge[j][j] = true;
                } else {
                    boolean b = c[j] == c[j + i];
                    if (i == 1){
                        judge[j][j + i] = b;
                    } else {
                        judge[j][j + i] = b && judge[j + 1][j + i - 1];
                    }
                }
                if (judge[j][j + i] && i + 1 > res.length()){
                    res = s.substring(j, j + i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(new Solution33().longestPalindrome(str));
    }
}
/*
* 运行时间更短的写法
* 思路：边界情况有两种，长度为1和2的子串，通过向两边扩展的做法求最长回文子串
* public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//长度为1的子串扩展
            int len2 = expandAroundCenter(s, i, i + 1);//长度为2的子串扩展
            int len = Math.max(len1, len2);//获取两种扩展情况的最大长度
            if (len > end - start) {//判断长度是否大于当前最长回文子串的长度
                start = i - (len - 1) / 2;//获取起始坐标
                end = i + len / 2;获取结束坐标
            }
        }
        return s.substring(start, end + 1);//通过两个坐标返回最长回文子串
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
* */