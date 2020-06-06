package meituan;

import java.util.Scanner;

/**
 * @ClassName ShuangGuiDao
 * Description TODO
 * @Author zwz
 * @Date 2020/3/14 10:19
 * @Version 1.0
 **/
public class ShuangGuiDao {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        char[][] map = new char[2][n];
        for (int row=0;row<2;row++){
            String str=input.nextLine();
            map[row]=str.toCharArray();
        }
        if (map[0][0]=='X'||map[1][n-1]=='X'){
            System.out.println(-1);
        }
        if(n==1||n==2){
            System.out.println(1);
        }else{
            int count=1;
            for (int i=1;i<n-1;i++){
                if (map[0][i]=='.'&&map[1][i]=='.'){
                    count*=2;
                }else if (map[0][i]=='X'&&map[1][i]=='X'){
                    System.out.println(-1);
                }
            }
            System.out.println(count);
        }
    }
}
