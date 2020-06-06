package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName offer2
 * Description TODO
 * @Author zwz
 * @Date 2020/4/1 15:52
 * @Version 1.0
 **/
public class offer2 {

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

    public static int helper(int m,int[] nums,int[] quanzhi) {
        int min=0;
        backtrack(new ArrayList<>(),nums,quanzhi,min,0,0);
        return min;
    }

    private static void backtrack(List<Integer> tempList, int[] nums, int[] quanzhi,int min,int index,int tempmin){
        List<Integer> list=new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        if(tempList.size() == nums.length){
            min=Math.min(min,tempmin);
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                if(nums[i]==nums[index]) continue;
                tempList.add(nums[i]);
                backtrack(tempList, nums, quanzhi,min,index+1,tempmin+quanzhi[i-1]*Math.abs(list.indexOf(nums[i])-i));
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
