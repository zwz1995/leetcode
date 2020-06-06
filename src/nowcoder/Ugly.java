package nowcoder;

import java.util.ArrayList;

/**
 * @ClassName Ugly
 * Description TODO
 * @Author zwz
 * @Date 2020/2/10 22:54
 * @Version 1.0
 **/
public class Ugly {
    private ArrayList<Integer> array=new ArrayList();
    public int GetUglyNumber_Solution(int index) {
        if(index<=0) return 0;
        if(index==1) return 1;
        int count=1;
        int i=1;
        while(count!=index){
            i++;
            if(isUgly(i)){
                count++;
                array.add(i);
            }
        }
        return i;
    }
    private boolean isUgly(int i){
        if(i<=0) return false;
        if(i==1) return true;
        if(i==2||i==3||i==5||(i%2==0)&&array.contains(i/2)||(i%3==0)&&array.contains(i/3)||(i%5==0)&&array.contains(i/5)){
            return true;
        }else{return false;}

    }

    public static void main(String[] args) {
        System.out.println(new Ugly().GetUglyNumber_Solution(100));
    }
}
