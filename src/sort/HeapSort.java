package sort;

/**
 * @ClassName HeapSort
 * Description TODO
 * @Author zwz
 * @Date 2020/3/24 7:58
 * @Version 1.0
 **/
public class HeapSort {
    public static void myMinHeapSort(int[] array){
        int i;
        int len=array.length;
        for (i=len/2-1;i>=0;i--){
            adjustMinHeap(array,i,len-1);
        }
        for (i=len-1;i>=0;i--){
            int tmp=array[0];
            array[0]=array[i];
            array[i]=tmp;
            adjustMinHeap(array,0,i-1);
        }
    }

    private static void adjustMinHeap(int[] a, int pos, int len) {
        int temp;
        int child;
        for (temp=a[pos];2*pos+1<=len;pos=child){
            child=2*pos+1;
            if (child<len&&a[child]<a[child+1]){
                child++;
            }
            if (a[child]<temp){
                a[pos]=a[child];
            }
            break;
        }
        a[pos]=temp;
    }
}
