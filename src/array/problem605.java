package array;

public class problem605 {
	public boolean canPlaceFlowers(int[] flowerbed,int n) {
		/* 贪婪算法 */
		int count=0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i]==0) {
				int next=(i==flowerbed.length-1)?0:flowerbed[i+1];
				int pre=(i==0)?0:flowerbed[i-1];
				if (next==0&&pre==0) {
					flowerbed[i]=1;
					count++;
				}
			}
		}
		return count>n;
	}
}
