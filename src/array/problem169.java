package array;

public class problem169 {
	public int majorityElement(int[] nums) {
		int major=nums[0];
		int count=1;
		for (int i = 1; i < nums.length; i++) {
			if (major==nums[i]) {
				count++;
			}else if (count==0) {
				major=nums[i];
				count++;
			}else {
				count--;
			}
		}
		return major;
	}
}
