package array;

public class problem198 {
	 public int rob2(int[] nums) {
		 	//选第i个房间 ： dp[i] = dp[i-2]+ nums[i] ;
	        //不选第i个房间： dp[i] = dp[i-1] ;
	        //dp[i]为前i个元素的最优解
	        int[] dp = new int[nums.length+2] ;
	        if(nums.length == 0) return 0 ;
	        dp[0] = nums[0] ;
	        if(nums.length== 1) return dp[0] ;
	        dp[1] = nums[0]>nums[1]?nums[0]:nums[1] ;
		/* dp[0]为1，
		 * 根据规则dp[1]只能在0和1这两个位置选择一个，则dp[1]=2，
		 * dp[3]在0，1和2三个位置中选择，根据规则小偷不能偷相邻的房屋，那么只有两种选择：只选择位置1或者选择位置0和2，我们要怎么选择呢？其实也很简单，我们只要选择那个得到更大金额的即可，即dp[i]=max(dp[i-1],dp[i-2]+nums[i]) */
	        for(int i=2;i<nums.length;i++)
	        {
	            dp[i] = dp[i-2]+nums[i]>dp[i-1]?dp[i-2]+nums[i]:dp[i-1] ;
	        }
	        return dp[nums.length-1] ;
	    
	    }
}
