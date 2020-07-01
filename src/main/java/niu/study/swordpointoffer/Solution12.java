package niu.study.swordpointoffer;

public class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i<0 || j >= board[0].length || j < 0 || board[i][j] != words[k])
            return false; // 剪枝，不合法直接返回，防止多余操作
        if (k == words.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i-1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}