package array;

import java.util.Arrays;

public class problem300 {
    public int lengthofLTS(int[] nums){
        if (nums.length==0){
            return 0;
        }
        int max=1;
        for (int i=0;i<nums.length;i++){
            int temp=nums[i];
            int jishu=1;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]>temp){
                    jishu++;
                    temp=nums[j];
                }
            }
            max=(max>jishu)?max:jishu;
        }
        return max;
    }
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

}
