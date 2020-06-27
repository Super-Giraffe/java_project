package LeetCode;

/**
 * 题目：罗马数字转整数
 */
public class Solution38 {
    public static void main(String[] args) {
        String num = "MCMXCIV";
        int res = new Solution38().romanToInt(num);
        System.out.println(res);
    }
    public int romanToInt(String s) {
        int qian = 0;
        int bai = 0;
        int shi = 0;
        int ge = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case 'M' :
                    qian++;
                    break;
                case 'D':
                    bai += 5;
                    break;
                case 'C':
                    if (i + 1 < chars.length && (chars[i + 1] == 'D' || chars[i + 1] == 'M')){
                        if (chars[i + 1] == 'D'){
                            bai += 4;
                        } else {
                            bai += 9;
                        }
                        i++;
                    } else {
                        bai++;
                    }
                    break;
                case 'L':
                    shi += 5;
                    break;
                case 'X':
                    if (i + 1 < chars.length && (chars[i + 1] == 'L' || chars[i + 1] == 'C')){
                        if (chars[i + 1] == 'L'){
                            shi += 4;
                        } else {
                            shi += 9;
                        }
                        i++;
                    } else {
                        shi++;
                    }
                    break;
                case 'V':
                    ge += 5;
                    break;
                case 'I':
                    if (i + 1 < chars.length && (chars[i + 1] == 'V' || chars[i + 1] == 'X')){
                        if (chars[i + 1] == 'V'){
                            ge += 4;
                        } else {
                            ge += 9;
                        }
                        i++;
                    } else {
                        ge++;
                    }
                    break;
            }
        }
        return qian * 1000 + bai * 100 + shi * 10 + ge;
    }
}
