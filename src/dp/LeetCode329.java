package dp;

/**
 * @ClassName LeetCode329
 * Description TODO
 * @Author zwz
 * @Date 2020/3/24 10:38
 * @Version 1.0
 **/
public class LeetCode329 {
    private int n,m;
    private int[][] f;
    private int[] dx={-1,0,1,0},dy={0,1,0,-1};
    public  int longestIncreaseingPath(int[][] matrix){
        int res=0;
        n=matrix.length;
        if (n==0) return res;
        m=matrix[0].length;
        f=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                res=Math.max(res,dp(matrix,i,j));
            }
        }
        return 0;
    }

    private int dp(int[][] matrix, int x, int y) {
        if (f[x][y]!=0) return f[x][y];
        f[x][y]=1;
        for (int i=0;i<4;i++){
            int a=x+dx[i];
            int b=y+dy[i];
            if (a>=0&&a<n&&b>=0&&b<m&&matrix[a][b]<matrix[x][y]){
                f[x][y]=Math.max(f[x][y],dp(matrix,a,b)+1);
            }
        }
        return f[x][y];

    }
}
