package LeetCode;

import java.util.Stack;

/**
 * 题目：包含min函数的栈
 * Q：如果将最小元素pop掉，但次最小元素不一定是将栈B的栈顶元素pop之后的栈顶元素
 * A：借助辅助栈B记录栈A中的最小值，A中无论push进多少元素，只要都大于栈B的栈顶元素，要将最小元素pop需要将之前push进的元素都pop掉才行，
 *    所以次最小元素必定是栈B中栈顶元素的前一个元素
 */

public class MinStack {
    Stack<Integer> A;
    Stack<Integer> B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.empty() || x <= B.peek()){
            B.push(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
