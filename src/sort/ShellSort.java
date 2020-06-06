package sort;

/**
 * @ClassName ShellSort
 * Description TODO
 * @Author zwz
 * @Date 2020/3/23 21:08
 * @Version 1.0
 **/
public class ShellSort {
    private static void shellSort(int[] a){
        int n=a.length;
        for(int step=n;step>0;step/=2){
            for (int i=step;i<n;i++){
                int j=i;
                int temp=a[j];
                while (j-step>=0&&a[j-step]>temp){
                    j=j-step;
                    a[j]=a[j-step];
                }
                a[j]=temp;
            }
        }
    }

}
