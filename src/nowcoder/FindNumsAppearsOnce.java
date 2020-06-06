package nowcoder;

/**
 * @ClassName FindNumsAppearsOnce
 * Description TODO
 * @Author zwz
 * @Date 2020/3/24 12:12
 * @Version 1.0
 **/
public class FindNumsAppearsOnce {
    public void findNumsAppersOnce(int[] array){
        int xor1=0;
        for (int i=0;i<array.length;i++){
            xor1=xor1^array[i];
        }
        int index=1;
        while ((index&xor1)==0){
            index=index<<1;
        }
        int result1=0,result2=0;
        for (int i=0;i<array.length;i++){
            if ((array[i]&index)==0){
                result1=result1^array[i];
            }else
                result2=result2^array[i];
        }

    }

    public static void main(String[] args) {
        String str="";
        System.out.println(str.length());
    }
}
