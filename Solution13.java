package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution13 {
    public String reverseWords(String s) {
        String res = "";
        String str = "";
        List<String> list = new ArrayList<>();
        char[] c = s.toCharArray();
        for (char a : c){
            if (a == ' '){
                if (!"".equals(str)){
                    list.add(str);
                    str = "";
                } else {
                    continue;
                }
            } else {
                str += a;
            }
        }
        if (!"".equals(str)){
            list.add(str);
        }
        if (list.size() == 0){
            return "";
        } else {
            for (int i = list.size() - 1; i > 0; i--) {
                res += list.get(i) + " ";
            }
            res += list.get(0);
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "the sky is blue";
        String str2 = "  hello world!  ";
        String str3 = "a good   example";
        System.out.println(new Solution13().reverseWords(str1));
        System.out.println(new Solution13().reverseWords(str2));
        System.out.println(new Solution13().reverseWords(str3));
    }
}
