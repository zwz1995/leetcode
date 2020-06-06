package array;

public class problem88 {
	public void merge(int[]nums1,int m,int[]nums2,int n) {
		for (int j = 0; j < n; j++) {
			int flag=0;
			for (int i = 0; i < m; i++) {
				if (nums2[j]<nums1[i]) {					
					for (int k = m-1; k>i-1; k--) {
						nums1[k+1]=nums1[k];				
					}
					nums1[i]=nums2[j];
					m++;
					flag=1;
					break;
				}
			}
			if (flag==0) {
				nums1[m]=nums2[j];
				m++;
			}						
		}
	}

	/* 别人的解法，简洁快速 */
	public void merge1(int A[], int m, int B[], int n) {
		 int i=m-1, j=n-1, k=m+n-1;
		    while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
		    while (j>-1)         A[k--]=B[j--];
    }
}
