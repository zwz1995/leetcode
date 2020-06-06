package ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName problem3
 * Description TODO
 * @Author zwz
 * @Date 2020/4/11 19:58
 * @Version 1.0
 **/
public class problem3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        int[] res=new int[n];
        for (int i=0;i<n;i++){
            int m=Integer.valueOf(sc.nextLine());
            int[] nums=new int[m];
            String[] str=sc.nextLine().split(" ");
            for (int j=0;j<m;j++){
                nums[j]=Integer.valueOf(str[j]);
            }
            int[] quanzhi=new int[m];
            String[] strr=sc.nextLine().split(" ");
            for (int j=0;j<m;j++){
                quanzhi[j]=Integer.valueOf(strr[j]);
            }
            res[i]=helper(m,nums,quanzhi);
        }
        for (int i=0;i<n;i++){
            System.out.println(res[i]);
        }

    }

    private static int helper(int m, int[] nums, int[] quanzhi) {
        int sum=0;
        for (int i=0;i<m;i++){
            sum+=quanzhi[i];
        }
        if (m%2==0) return sum;
        sum=0;
        Arrays.sort(quanzhi);
        while (m!=3){
            sum+=quanzhi[m-1];
            m--;
        }
        int sum1=quanzhi[0]*2+quanzhi[1]+quanzhi[2];
        int sum2=quanzhi[0]+quanzhi[1]+quanzhi[2]* 2;
        return Math.min(sum1,sum2)+sum;
    }
}
