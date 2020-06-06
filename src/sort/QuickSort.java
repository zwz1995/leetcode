package sort;

/**
 * @ClassName QuickSort
 * Description TODO
 * @Author zwz
 * @Date 2020/3/23 20:39
 * @Version 1.0
 **/
public class QuickSort {
    private static void quickSort(int[] a,int l,int h){
        int i,j;
        if(l>=h) return;
        i=l;
        j=h;
        int index=a[i];
        while (i<j){
            //里面所有的方法都要加i<j
           while(i<j&&a[j]>=index) j--;
           if(i<j) a[i++]=a[j];
           while (i<j&&a[i]<index) i++;
           if(i<j) a[j--]=a[i];
        }
        //少了这句
        a[i]=index;
        quickSort(a,l,i-1);
        quickSort(a,i+1,h);

    }
}
