package array;

public class problem26 {
	public int removeDuplicates(int[]nums) {
		/* a和i一起向后遍历，进行比较,快指针慢指针 */
		int a=0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[a]!=nums[i]) {
				a++;		
				nums[a]=nums[i];
			}
		}
		return a;
	}
}
