package array;

public class problem581 {
	public int findUnsortedSubarray(int[] nums) {
		int zuo=-1;
		int you=nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (i==nums.length-1) {
				return 0;
			}
			if (nums[i]>nums[i+1]) {
				zuo=i;
				break;
			}
			
		}
		for (int i = nums.length-1; i > -1; i--) {
			if (i==0) {
				return 0;
			}
			if (nums[i]<nums[i-1]) {
				you=i;
				break;
			}
			
		}
		return you-zuo+1;
	}
	
	   /**
     *参考评论中代码，从前往后遍历找到右边最大的乱序下标，从后往前遍历找到左边最小的乱序下标
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray1(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int R = 0;
        int L = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (max > nums[i]) {
                R = i;
            }

            max = Math.max(max, nums[i]);
        }

        for (int j = nums.length - 1; j>=0; j--) {
            if (min < nums[j]) {
                L = j;
            }
            min = Math.min(min, nums[j]);

        }

        return R == L ? 0 : R - L + 1;
    }
}
