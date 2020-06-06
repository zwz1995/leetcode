package array;

public class problem674 {
	public static void main(String[] args) {
		problem674 p=new problem674();
		int []a=new int[] {1,3,5,7};
		System.out.println(p.findLengthOfLCIS(a));
	}
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length==0) {
			return 0;
		}
		int tmax=1;
		int max=1;
		for (int i = 1; i < nums.length; i++) {
			
			if (nums[i]<=nums[i-1]) {				
				tmax=Math.max(tmax, max);
				max=1;
			}else {
				max++;
			}
			if (i==nums.length-1) {
				tmax=Math.max(tmax, max);
			}
		}
		return tmax;
	}
}
