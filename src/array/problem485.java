package array;

public class problem485 {
	public int findMaxConsecutiveOnes(int[] nums) {
		if (nums.length==1) {
			if (nums[0]==1) {
				return 1;
			}else return 0;
		}
		int max=0;
		int temp=0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]==1) {
				if(i+1<nums.length) {
					temp++;
				}else {
					temp++;
					max=Math.max(max,temp);
				}
			}else {
				max=Math.max(max, temp);
				temp=0;
			}
		}
		return max;
	}
}
