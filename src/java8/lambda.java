package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName lambda
 * Description TODO
 * @Author zwz
 * @Date 2020/3/28 20:40
 * @Version 1.0
 **/
public class lambda {
    //取代匿名内部类
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("nothing");
            }
        }).start();
        new Thread(
                ()-> System.out.println("lambda")
        ).start();


        List<String> list= Arrays.asList("i","love","you");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1==null)
                    return -1;
                if (o2==null)
                    return 1;
                return o1.length()-o2.length();
            }
        });
        Collections.sort(list,((o1, o2) -> {
            if (o1==null)
                return -1;
            if (o2==null)
                return 1;
            return o1.length()-o2.length();
        }));

        for (String str:list){
            System.out.println(str);
        }
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        list.forEach((s)-> System.out.println(s));
    }
}
