package LeetCode;

/**
 * 题目：拥有最多糖果的孩子
 */

import java.util.ArrayList;
import java.util.List;

public class Solution10 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            max = max > candy ? max : candy;
        }
        int extra = max - extraCandies;
        for (int candy : candies){
            result.add(candy >= extra);
        }
        return result;
    }
}
