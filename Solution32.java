package LeetCode;

/**
 * 题目：最长公共前缀
 */

class Solution32 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
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