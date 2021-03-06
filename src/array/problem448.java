package array;

import java.util.ArrayList;

public class problem448 {
	public ArrayList<Integer> findDisappearedNumbers(int[] nums){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int val=Math.abs(nums[i])-1;
			if (nums[val]>0) {
				nums[val]=-nums[val];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0) {
				ret.add(i+1);
			}
		}
		return ret;
	}
}
