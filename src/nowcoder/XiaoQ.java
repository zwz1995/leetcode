package nowcoder;

import java.util.*;
/**
 * @ClassName XiaoQ
 * Description TODO
 * @Author zwz
 * @Date 2020/1/27 10:25
 * @Version 1.0
 **/
public class XiaoQ {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] a=str.split(" ");
        int n=Integer.valueOf(a[0]);
        int m=Integer.valueOf(a[1]);
        char color[][]=new char[n][m];
        for(int i=0;i<n;i++){
            String tem=sc.nextLine();
            for(int j=0;j<tem.length();j++){
                color[i][j]=tem.charAt(j);
            }
        }
        getMinStep(color,n,m);
        sc.close();

    }

    private static void getMinStep(char color[][],int n,int m){
        int step=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(color[i][j]=='Y'){
                    dfs_y(color,n,m,i,j);
                    step++;
                }else if(color[i][j]=='B'){
                    dfs_b(color,n,m,i,j);
                    step++;
                }else if(color[i][j]=='G'){
                    dfs_y(color,n,m,i,j);
                    step++;
                    dfs_b(color,n,m,i,j);
                    step++;
                }
            }
        }
        System.out.println(step);
    }

    private static void dfs_y(char color[][],int n,int m,int i,int j){
        if(i<n&&i>=0&&j<m&&j>=0&&(color[i][j]=='Y'||color[i][j]=='G')){
            if(color[i][j]=='G'){
                color[i][j]='B';
            }else {
                color[i][j]='X';
            }
            dfs_y(color,n,m,i+1,j+1);
            dfs_y(color,n,m,i-1,j-1);
        }

    }

    private static void dfs_b(char color[][],int n,int m,int i,int j){
        if(i<n&&i>=0&&j<m&&j>=0&&(color[i][j]=='B'||color[i][j]=='G')){
            if(color[i][j]=='G'){
                color[i][j]='Y';
            }else {
                color[i][j]='X';
            }
            dfs_b(color,n,m,i+1,j+1);
            dfs_b(color,n,m,i-1,j-1);
        }

    }
}
