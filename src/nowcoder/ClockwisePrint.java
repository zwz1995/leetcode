package nowcoder;

import java.util.ArrayList;

/**
 * @ClassName ClockwisePrint
 * Description TODO
 * @Author zwz
 * @Date 2020/2/1 10:56
 * @Version 1.0
 **/
public class ClockwisePrint {
    public static void main(String[] args) {
        int [][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}} ;
        ArrayList array=new ClockwisePrint().printMatrix(matrix);
    }
    private int n;
    private int m;
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res=new ArrayList();
        n=matrix.length;
        if(n==0) return res;
        m=matrix[0].length;
        int [][] isPrint=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dfs(matrix,isPrint,res,i,j);
            }
        }
        return res;
    }
    private void dfs(int[][] matrix,int[][] isPrint,ArrayList<Integer> res,int x,int y){
        if(x<0||x>=n||y<0||y>=m||isPrint[x][y]==1) return;
        res.add(matrix[x][y]);
        isPrint[x][y]=1;
        dfs(matrix,isPrint,res,x,y+1);
        dfs(matrix,isPrint,res,x+1,y);
        dfs(matrix,isPrint,res,x,y-1);
        dfs(matrix,isPrint,res,x-1,y);
    }
}
