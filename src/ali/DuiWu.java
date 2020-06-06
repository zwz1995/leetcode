package ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName DuiWu
 * Description TODO
 * @Author zwz
 * @Date 2020/3/23 21:22
 * @Version 1.0
 **/
public class DuiWu {
    private static List<List<Integer>> result=new ArrayList();
    private static int length;
    private static long count;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        length=Integer.valueOf(sc.nextLine());
        int[] nums=new int[length];
        for (int i=0;i<length;i++){
            nums[i]=i;
        }
        List<Integer> select=new ArrayList<>();
        helper(select,nums,0,0);
        System.out.println(count);
    }

    private static void helper(List<Integer> select, int[] nums, int pos,int iter) {
        result.add(new ArrayList<>(select));
        count+=select.size();
        if(pos==length){
            return;
        }
        for (int i=iter;i<nums.length;i++){
            if(select.contains(nums[i])) continue;
            select.add(nums[i]);
            helper(select,nums,pos+1,i);
            select.remove(select.size()-1);
        }
    }

}
