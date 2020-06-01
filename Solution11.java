package LeetCode;

/**
 * 题目：栈的压入、弹出序列
 */

import java.util.Stack;

public class Solution11 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> num = new Stack<>();
        int i = 0;
        for (int push : pushed){
            num.push(push);
            while (!num.empty() && num.peek().equals(popped[i])){
                i++;
                num.pop();
            }
        }
        if (num.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
