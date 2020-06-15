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
