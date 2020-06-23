package LeetCode;

/**
 * 题目：Z字形变换
 */
public class Solution36 {
    public String convert(String s, int numRows) {
        int len = s.length() / 2 + 1;
        String res = "";
        String[][] c = new String[numRows][len];
        int flag = 0;
        int x = 0, y = 0;
        if (numRows == 1){
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            if (x == 0){
                flag = 0;
            }
            if (x == numRows - 1){
                flag = 1;
            }
            c[x][y] = s.charAt(i) + "";
            if (flag == 0){
                x++;
            } else {
                x--;
                y++;
            }
        }
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < len; j++){
                if(c[i][j] !=null){
                    res += c[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String res = new Solution36().convert("LEETCODEISHIRING",3);
        System.out.println(res);
    }
}
/**
 * public String convert(String s, int numRows) {
 *         if(numRows < 2) return s;
 *         List<StringBuilder> rows = new ArrayList<StringBuilder>();
 *         for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
 *         int i = 0, flag = -1;
 *         for(char c : s.toCharArray()) {
 *             rows.get(i).append(c);
 *             if(i == 0 || i == numRows -1) flag = - flag;
 *             i += flag;
 *         }
 *         StringBuilder res = new StringBuilder();
 *         for(StringBuilder row : rows) res.append(row);
 *         return res.toString();
 *     }
 */
