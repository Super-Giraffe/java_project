package LeetCode;

/**
 * 题目：矩阵中的路径
 */

public class Solution23 {
    public boolean exist(char[][] board, String word) {
        boolean[][] judge = new boolean[board.length][board[0].length];
        int position = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (hasPath(board, word, i, j, position, judge)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasPath(char[][] board, String word, int x, int y, int position, boolean[][] judge){
        char[] c = word.toCharArray();
        if (position == word.length()){
            return true;
        }
        boolean haspath = false;
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == c[position] && !judge[x][y]){
            position++;
            judge[x][y] = true;
            haspath = hasPath(board, word, x - 1, y, position, judge) || hasPath(board, word, x + 1, y, position, judge) || hasPath(board, word, x, y - 1, position, judge) || hasPath(board, word, x, y + 1, position, judge);
            if (!haspath){
                position--;
                judge[x][y] = false;
            }
        }
        return haspath;
    }

    public static void main(String[] args) {
//        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String str = "abcd";
        boolean result = new Solution23().exist(board, str);
        System.out.println(result);
    }
}
