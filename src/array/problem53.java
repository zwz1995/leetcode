package array;

public class problem53 {
	/*
	 * 对于含有正数的序列而言,最大子序列肯定是正数,所以头尾肯定都是正数.我们可以从第一个正数开始算起,每往后加一个数便更新一次和的最大值;当当前和成为负数时,
	 * 则表明此前序列无法为后面提供最大子序列和,因此必须重新确定序列首项.
	 */
	public static void main(String[] args) {
		int[]a= new int[]{-1};
		System.out.println(new problem53().maxSubArray(a));
	}
	public int maxSubArray1(int[]nums) {
		int flag=1;
		int fumax=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>0) { flag=1;break;}
			 fumax=nums[i];
			flag=0;
			if (nums[i]>fumax) {
				fumax=nums[i];
			}
		}
		if (flag==0) {
			return fumax;
		}
		
		int zuizhongsum=0;
		for (int i = 0; i < nums.length; i++) {	 
			if (nums[i]>0) {
				int maxsum=nums[i];
				int sum=nums[i];
				for (int j = i+1; j < nums.length; j++) {
					sum=sum+nums[j];
					if (sum<=0) break;
					if (sum>maxsum) {
						maxsum=sum;
					}
				}
				if (maxsum>zuizhongsum) {
					zuizhongsum=maxsum;
				}
			}
		}
		return zuizhongsum;	
	}
	/* 官方题解 */
	public int maxSubArray(int[]nums) {
		int res=nums[0];
		int sum=0;
		for (int i = 0; i < nums.length; i++) {
			if (sum>0) {
				sum=sum+nums[i];
			}
			else {
				sum=nums[i];
				res=Math.max(res, sum);
			}
		}
		return res;
	}
}
