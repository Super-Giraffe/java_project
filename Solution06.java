package LeetCode;

/**
 * 题目：和可被K整除的数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 解题思路：P[i] = 数组A中前i个元素的和,连续子数组的和sum(i，j) = P[j] - P[i]，所以sum每次加上一个元素(下标为j)，如果sum对K取余的值
 * 在Map中已存在，且值为value，说明存在value个P[i],使得(P[j] - P[i]) % K == 0.
 */

import java.util.HashMap;
import java.util.Map;

public class Solution06 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }
}
