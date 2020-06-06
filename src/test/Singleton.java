package test;

/**
 * @ClassName Singleton
 * Description TODO
 * @Author zwz
 * @Date 2020/3/7 18:05
 * @Version 1.0
 **/
public class Singleton {
    private static Singleton instance=null;

    private Singleton(){};

    public static Singleton getInstance(){
        if (instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance= new Singleton();
                }
            }
        }
        return instance;

    }
}
