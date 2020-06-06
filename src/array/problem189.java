package array;

public class problem189 {
	public void rotate(int[] nums,int k) {
		for (int i = 0; i < k; i++) {
			int temp=nums[nums.length-1];
			for (int j = nums.length-2; j >-1; j--) {
				nums[j+1]=nums[j];
			}
			nums[0]=temp;
		}
		System.out.println(nums);
	}
}
