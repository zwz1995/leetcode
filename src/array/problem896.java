package array;

public class problem896 {
	public boolean isMonotonic(int[] A) {
		int flag=0;
		for (int i = 1; i < A.length; i++) {
			if (A[i]>A[i-1]) {
				flag=1;
				break;
			}else if(A[i]<A[i-1]) {
				flag=2;
				break;
			}
		}
		if (flag==0) {
			return true;
		}
		if (flag==1) {
			for (int i = 1; i < A.length; i++) {
				if (A[i]<A[i-1]) {
					flag=0;
				}
			}
		}
		if (flag==2) {
			for (int i = 1; i < A.length; i++) {
				if (A[i]>A[i-1]) {
					flag=0;
				}
			}
		}
		if (flag==0) {
			return false;
		}else {
			return true;
		}
		
		
	}
}