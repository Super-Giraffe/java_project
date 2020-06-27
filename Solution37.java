package LeetCode;

/**
 * 题目：整数转罗马数字
 */
public class Solution37 {
    public static void main(String[] args) {
        int num = 58;
        String res = new Solution37().intToRoman(num);
        System.out.println(res);
    }
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        int qian = num / 1000;
        int bai = (num % 1000) / 100;
        int shi = (num % 100) / 10;
        int ge = num % 10;
        for (int i = 0; i < qian; i++){
            str.append("M");
        }
        if (bai == 4 || bai == 9){
            if (bai == 4){
                str.append("CD");
            } else {
                str.append("CM");
            }
        } else {
            if (bai / 5 == 1){
                str.append("D");
            }
            for (int i = 0; i < (bai % 5); i++){
                str.append("C");
            }
        }
        if (shi == 4 || shi == 9){
            if (shi == 4){
                str.append("XL");
            } else {
                str.append("XC");
            }
        } else {
            if (shi / 5 == 1){
                str.append("L");
            }
            for (int i = 0; i < shi % 5; i++){
                str.append("X");
            }
        }
        if (ge == 4 || ge == 9){
            if (ge == 4){
                str.append("IV");
            } else {
                str.append("IX");
            }
        } else {
            if (ge / 5 == 1){
                str.append("V");
            }
            for (int i = 0; i < ge % 5; i++){
                str.append("I");
            }
        }
        return str.toString();
    }
}
