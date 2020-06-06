package ali;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Test
 * Description TODO
 * @Author zwz
 * @Date 2020/3/25 14:46
 * @Version 1.0
 **/
public class Test {
    private static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        int[][] nums=new int[3][n];
        for (int i=0;i<3;i++){
            String str=sc.nextLine();
            String[] s=str.split(" ");
            for (int j=0;j<n;j++){
                nums[i][j]=Integer.valueOf(s[j]);
            }
        }

        ArrayList<Integer> tmp=new ArrayList();
        dfs(nums,tmp,0);
        System.out.println(min);
    }

    private static void dfs(int[][] nums, ArrayList tmp, int start) {
        if (start==nums[0].length){
            min=Math.min(min,maxvalue(tmp));
            return;
        }
        for (int i=0;i<3;i++){
            tmp.add(nums[i][start]);
            dfs(nums,tmp,start+1);
            tmp.remove(tmp.size()-1);
        }
    }

    private static int maxvalue(ArrayList<Integer> tmp){
        int sum=0;
        for (int i=0;i<tmp.size()-1;i++){
            sum+=Math.abs(tmp.get(i+1)-tmp.get(i));
        }
        return sum;
    }
}
