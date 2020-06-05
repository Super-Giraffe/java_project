package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution16 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length;) {
            if (!map.containsKey(c[i])){
                map.put(c[i], i);
                i++;
            } else {
                if (map.size() > max){
                    max = map.size();
                }
                i = map.get(c[i]) + 1;
                map.clear();
            }
        }
        if (map.size() > max){
            max = map.size();
        }
        return max;
    }
}
