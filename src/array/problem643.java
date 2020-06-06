package array;

public class problem643 {
	public double findMaxAverage(int[]nums,int k) {
		int total=Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			if (i<k) {
				total=i+total;
			}else {
				int temp=total-nums[i-k]+nums[i];
				total=Math.max(total, temp);
				
			}
		}
		return total;
	}
}
