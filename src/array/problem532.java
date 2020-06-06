package array;

import java.util.HashSet;
import java.util.Set;

public class problem532 {
	public int findPairs(int[]nums,int k) {
		if(nums == null || nums.length == 0 || k < 0) return 0;
        //set不能存储重复元素
        Set<Integer> set = new HashSet<>();
        Set<Integer> repeat = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                repeat.add(num);
            }else{
                set.add(num);
            }
        }
        
        if(k == 0) return repeat.size();
        else{
            int res = 0;
            for(int num : set){
                if(set.contains(num - k)){
                    res++;
                }
            }    
            return res;
        }
	}
}
