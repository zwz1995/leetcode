package string;

/**
 * @ClassName problem521
 * Description TODO
 * @Author zwz
 * @Date 2019/12/2 21:50
 * @Version 1.0
 **/
public class problem521  {
    public int findLUSlength(String a,String b){
        if (a.equals(b)){
            return -1;
        }else{
            return Math.max(a.length(),b.length());
        }
    }
}
