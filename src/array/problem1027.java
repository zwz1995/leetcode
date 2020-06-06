package array;

public class problem1027 {
    public int longestArithSeqLength(int[] A){
        int[][] B=new int[A.length][20001];
        int max=0;
        for (int i=1;i<A.length;i++){
            for (int j=0;j<i;j++){
                int diff=A[i]-A[j]+10000;
                if (B[j][diff]!=0){
                    B[i][diff]=B[j][diff]+1;
                }else {
                    B[i][diff]=2;
                }
                max=(max>B[i][diff])?max:B[i][diff];
            }
        }
        return max;
    }
}
