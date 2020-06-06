package nowcoder;

/**
 * @ClassName Swap
 * Description TODO
 * @Author zwz
 * @Date 2020/2/12 10:46
 * @Version 1.0
 **/
public class Swap {
    private void swap(int a,int b){
        int temp=a^b;
        a=temp^a;
        b=temp^b;
        System.out.println(a+" "+b);
    }

    public static void main(String[] args) {
        new Swap().swap(100,299);
        System.out.println("abc    ".trim());

    }

}
