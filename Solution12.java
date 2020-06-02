package LeetCode;

/**
 * 题目：求1+2+...+n
 * 要求：不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */

public class Solution12 {
    public int sumNums(int n) {
//        可以使用递归的方式实现,但这里终止条件用到了if语句
//        解决办法：运用逻辑运算符的短路效应
//        if (n == 1){
//            return n;
//        }
//        n += sumNums(n - 1);
//        return n;
//        如果n等于1时，递归不执行,&&后跟要执行的语句，因为这是布尔表达式，所有后面要跟上>0,不然会报错
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
