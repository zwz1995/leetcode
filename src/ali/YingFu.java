package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName YingFu
 * Description TODO
 * @Author zwz
 * @Date 2020/3/20 18:41
 * @Version 1.0
 **/
public class YingFu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        String[] s=new String[n];
        for (int i=0;i<n;i++){
            s[i]=sc.nextLine();
        }
        System.out.println(s);
        //dp算法
        //f[i]表示以i字符串结尾的最大字符串个数
        int[] f=new int[n];
        f[0]=s[0].length();
        for (int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(j==i){
                    f[i]=s[j].length();
                }else{
                    if(s[j].charAt(s[j].length()-1)<=s[i].charAt(0)){
                        f[i]=Math.max(f[i],f[j]+s[i].length());
                    }
                }
            }
        }
        int res=0;
        for(int i=0;i<f.length;i++){
            res=Math.max(res,f[i]);
        }
        System.out.println(res);
    }


    public static void mai(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> melodies = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            String input = sc.nextLine();
            if (input.length() == 0) {
                continue;
            }
            melodies.add(input);
        }

        String[] mel = new String[melodies.size()];
        melodies.toArray(mel);
        int[] dp = new int[mel.length];
        for (int j = mel.length - 1; j >= 0; j--) {
            for (int i = j; i < mel.length; i++) {
                if (i == j) {
                    dp[j] = mel[j].length();
                } else if (mel[j].charAt(mel[j].length() - 1) <= mel[i].charAt(0)) {
                    dp[j] = Math.max(dp[j], mel[j].length() + dp[i]);
                }
            }
        }
        System.out.println(dp[0]);;
    }


}
