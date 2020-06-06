package array;

public class problem754 {
	public static void main(String[] args) {
		problem754 p=new problem754();
		System.out.println(p.reachNumber(2));
	}
	public int reachNumber(int target) {
		int ttarget=Math.abs(target);
		
		int i=1;
		int sum=0;
		while (sum<ttarget) {
			sum+=i;
			i++;
		}
		if (sum==ttarget) {
			return i-1;
		}
		int sum1=sum-i+1;
		int k=(ttarget-sum1)>(sum-ttarget)?(sum-ttarget):(ttarget-sum1);
		if ((ttarget-sum1)<=(sum-ttarget)) {
			i--;
		}
//	int ki=(ttarget-sum1)>(sum-ttarget)?i:(i-1);
		return i-1+2*k;
		
	}
	 public int reachNumber1(int target) {
	        target = Math.abs(target);
	        int step = 0;
	        int sum = 0;
	        while (sum < target) {
	            step++;
	            sum += step;
	        }
	        while ((sum - target) % 2 != 0) {
	            step++;
	            sum += step;
	        }
	        return step;
	    }

	
}
