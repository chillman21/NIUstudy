package niu.study.swordpointoffer;

public class Solution13_dfs {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) { // k为数位和
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0; // 可行性剪枝
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    public static void main(String[] args) {
        Solution13_dfs solution13_dfs = new Solution13_dfs();
        System.out.println(solution13_dfs.movingCount(4, 6, 5));
    }
}
