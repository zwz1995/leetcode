import java.util.*;

/**
 * @description:
 * @author: zwz
 * @createDate: 2020/1/13
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
//        Calendar now = Calendar.getInstance();
//        System.out.println("年: " + now.get(Calendar.YEAR));
//        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
//        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
//        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
//        System.out.println("分: " + now.get(Calendar.MINUTE));
//        System.out.println("秒: " + now.get(Calendar.SECOND));
//        System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
//        System.out.println(now.getTime());
//
////        String a="1123adb";
////        char aa=a.charAt(1);
////        int k=a.indexOf(1);
////        HashMap m=new HashMap();
////
////        System.out.println(Integer.hashCode(100));
////        if (true&true){
////            System.out.println(11);
////        }
////        AtomicInteger i=new AtomicInteger(0);
////        String s=new String("11");
//        for (int i=1;i<2;i++){
//            System.out.println(123);
//        }
//
//
////        Arrays.asList( "a", "b", "d" ).forEach(e -> {
////            System.out.print( e );
////            System.out.print( e );
////        } );
//
//
//        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
//            int result = e1.compareTo( e2 );
//            return result;
//        } );
//        final ReentrantLock lock = new ReentrantLock();
//        int[] a=new int[]{1,1,1,1};
////        s = new String[]{"11", "111"};
//        ArrayList<Integer> list=new ArrayList(Arrays.asList(a));
//        System.out.println(a.toString());
//        System.out.println(list);
//
//        Map<Integer,Integer> map=new HashMap();
//        Iterator<Map.Entry<Integer,Integer>> entries=map.entrySet().iterator();
//        while (entries.hasNext()){
//            Map.Entry<Integer,Integer> entry=entries.next();
//            System.out.println(entry.getKey()+entry.getValue());
//        }
//        int i=Integer.valueOf("1");
//        System.out.println(++i);



//        Set<Integer> set=new HashSet<Integer>();
//        set.add(1);
//        set.add(2);
//        set.add(4);
//        set.add(2);
//        for (int k:set){
//            System.out.println(k);
//        }
//
//        List<Integer> list=new ArrayList<>(Arrays.asList(3,4,5,1));
//        Collections.sort(list);
//        System.out.println(list);
//        System.out.println(list);

        List<String> list2=new ArrayList<>();
        list2.add("d");
        list2.add("b");
        list2.add("e");
        list2.stream().sorted((o1,o2)->o1.compareTo(o2));
        System.out.println(list2.toString());
    }


}
