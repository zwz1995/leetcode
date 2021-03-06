package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class problem217 {
	/* n方复杂度 */
	public boolean containsDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]==nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
	/* nlogn复杂度 */
	public boolean containsDuplicate1(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-1; i++) {
			if (nums[i]==nums[i+1]) {
				return true;
			}
		}
		return false;
	}
	
	/* n复杂度 查字典*/
	public boolean containsDuplicate2(int[] nums) {
		final Set<Integer> distinct =new HashSet<Integer>();
		for (int num :nums) {
			if(distinct.contains(num)){
				return true;
			}
			distinct.add(num);
		}
		return false;
	}
}
