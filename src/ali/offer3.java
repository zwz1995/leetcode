package ali;

/**
 * @ClassName offer1
 * Description TODO
 * @Author zwz
 * @Date 2020/4/1 15:52
 * @Version 1.0
 **/
public class offer3 {
    public int get(char[][] pos){
        int m=pos.length;
        int n=pos[0].length;
        int max=0;
        int[][] dp=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (pos[i][j]=='.'){
                    Math.max(dp(pos,i,j,m,n),max);
                }
            }
        }
        return max;
    }

    //求必须包含i,j工位的最大个数
    private int dp(char[][] pos, int x, int y,int m,int n) {
        if (x>=m||x<0||y>=n||y<0||pos[x][y]=='*') return 0;
        int count=1;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i!=x-1&&i!=x+1&&j!=y-1&&j!=y+1&&pos[i][j]=='.'){
                    count+=1;
                }
            }
        }
        return 0;
    }
}
