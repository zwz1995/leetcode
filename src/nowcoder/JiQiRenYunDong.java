//package nowcoder;
//
///**
// * @ClassName jiqirenyundong
// * Description TODO
// * @Author zwz
// * @Date 2020/2/7 18:02
// * @Version 1.0
// **/
//public class jiqirenyundong {
//    public static void main(string[] args) {
//        int i=new jiqirenyundong().movingCount(5,10,10);
//        jiqirenyundong j=new jiqirenyundong();
//        System.out.println(j.getClass());
//        Class c=Class.forName("jiqirenyundong");
//        System.out.println(c);
//    }
//    private int count=0;
//    public int movingCount(int threshold, int rows, int cols)
//    {    int[][] flag=new int[rows][cols];
//        helper(threshold,rows,cols,count,flag,0,0);
//        return count;
//    }
//
//    private void helper(int threshold,int rows,int cols,int count,int[][] flag,int i,int j){
//        if(i<0||i>=rows||j<0||j>=cols||!judge(threshold,i,j)||flag[i][j]==1) return;
//        count++;
//        flag[i][j]=1;
//        helper(threshold,rows,cols,count,flag,i+1,j);
//        helper(threshold,rows,cols,count,flag,i-1,j);
//        helper(threshold,rows,cols,count,flag,i,j+1);
//        helper(threshold,rows,cols,count,flag,i,j-1);
//        return;
//    }
//
//    private boolean judge(int threshold,int i,int j){
//        int sum=0;
//        while(i!=0){
//            sum+=i%10;
//            i=i/10;
//        }
//        while(j!=0){
//            sum+=j%10;
//            j=j/10;
//        }
//        if(sum<=threshold){
//            return true;
//        }
//        return false;
//
//    }
//}
