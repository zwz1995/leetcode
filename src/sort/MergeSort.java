package sort;

/**
 * @ClassName MergeSort
 * Description TODO
 * @Author zwz
 * @Date 2020/3/23 20:09
 * @Version 1.0
 **/
public class MergeSort {
    public static void main(String[] args) {

    }

    //应该写成p,q,r和i,j,k
    private static void mergeSort(int[] a,int p,int q){
        if (p<q){
            int r=(p+q)/2;
            mergeSort(a,p,r);
            mergeSort(a,r+1,q);
            merge(a,p,r,q);
        }
    }

    private static void merge(int[] a, int p, int r, int q) {
        int n1=r-p+1,n2=q-r,i,j,k;
        //数组可以用L,R
        int[] A=new int[n1],B=new int[n2];
        for (k=p,i=0;k<n1;i++,k++){
            A[i]=a[k];
        }
        for (k=r+1,j=0;j<n2;j++){
            B[j]=a[k];
        }
        for (k=p,i=0,j=0;i<n1&&j<n2;k++){
            if (A[i]>B[j]){
                a[k]=B[j++];
            }else{
                a[k]=A[i++];
            }
        }
        if(i<n1){
            for (j=i;j<n1;j++,k++){
                a[k]=A[j];
            }
        }
        if (j<n2){
            for (i=j;i<n2;i++,k++){
                a[k]=B[i];
            }
        }
    }

}
