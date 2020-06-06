package ali;

import java.util.*;

/**
 * @ClassName offer1
 * Description TODO
 * @Author zwz
 * @Date 2020/4/1 15:52
 * @Version 1.0
 **/
public class offer4 {
    public static int[] wait(int[] a,int[] b){
        int n=a.length;
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>(
                new Comparator<Integer>() {
                    public int compare(Integer obj1, Integer obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });
        for (int i=0;i<n;i++){
            map.put(a[i]-b[i],i+1);
        }
        int[] res=new int[n];
        int j=0;
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iter = keySet.iterator();
        while (iter.hasNext()) {
            Integer key = iter.next();
            res[j]=map.get(key);
            j++;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(wait(new int[]{8,9,7},new int[]{5,8,3}));
    }




}
