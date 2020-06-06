package string;

import java.util.*;

public class problem49 {
    //最佳算法
    public List<List<String>> groupAnagrams(String[] strs){
        if (strs==null||strs.length==0) return new ArrayList<>();
        Map<String,List<String>> map= new HashMap<>();
        for (String s:strs){
            char[] ca=s.toCharArray();
            Arrays.sort(ca);
            String keystr=String.valueOf(ca);
            if (!map.containsKey(keystr))map.put(keystr,new ArrayList<String>());
            map.get(keystr).add(s);
        }
        return new ArrayList<>(map.values());

    }
}
