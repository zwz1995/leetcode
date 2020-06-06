package meituan;

import java.util.Scanner;

/**
 * @ClassName meituan.ZuiHaoYiYang
 * Description TODO
 * @Author zwz
 * @Date 2020/3/12 19:50
 * @Version 1.0
 **/
public class ZuiHaoYiYang {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        int x=input.nextInt();
        int[] A=new int[n];
        String str=input.nextLine();
        String[] a=str.split(" ");
        for (int i=0;i<n;i++){
            A[i]=Integer.valueOf(a[i]);
        }

        int[] B=new int[n];
        for (int i=0;i<n;i++){
            B[i]=A[i]|x;
        }
        int max=0;
        int temp=0;
        int count=0;
        for(int i=0;i<n;i++){
            temp=A[i];
            count=0;
            for (int j=0;j<n;j++){
                if(A[j]==temp||B[j]==temp){
                    count++;
                }
            }
            max=Math.max(max,count);
        }
        //再加一个
        for(int i=0;i<n;i++){
            temp=B[i];
            count=0;
            for (int j=0;j<n;j++){
                if(A[j]==temp||B[j]==temp){
                    count++;
                }
            }
            max=Math.max(max,count);
        }
        System.out.println(max);
    }
}
