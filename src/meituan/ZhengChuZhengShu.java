package meituan;

import java.util.Scanner;

/**
 * @ClassName ZhengChuZhengShu
 * Description TODO
 * @Author zwz
 * @Date 2020/3/14 12:07
 * @Version 1.0
 **/
public class ZhengChuZhengShu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int L=sc.nextInt();
        int R=sc.nextInt();

        int[] a=new int[k];
        for(int i=L;i<=R;i++){
            int m=i%k;
            a[m]++;
        }


    }
}
