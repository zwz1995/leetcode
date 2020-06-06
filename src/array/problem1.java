
package array;

import java.util.HashMap;
import java.util.Map;

public class problem1 {

    public int[] twoSum(int[] nums, int target) {
    		for (int i = 0; i < nums.length; i++) {
				int a =target-nums[i];
				for (int j = i+1; j < nums.length; j++) {
					if (a==nums[j]) {
						return new int[] {i,j};
					}
					
				}
			}
    		return null;
    }
    public int[] twoSum1(int[] nums, int target) {
    	Map<Integer, Integer> num = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
			num.put(nums[i],i);
		}
    	for (int i = 0; i < nums.length; i++) {
			int complent=target-nums[i];
			if (num.containsKey(complent)&&num.get(complent)!=i) {
				return new int[] {i,num.get(complent)};
			}
		}
    	return null;
    }

}
