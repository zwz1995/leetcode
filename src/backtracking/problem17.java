package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName problem17
 * Description TODO
 * @Author zwz
 * @Date 2019/11/29 10:53
 * @Version 1.0
 **/
public class problem17 {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans= new LinkedList<String>();//
        if (digits.isEmpty()) return ans;//特判
        ans.add("");
        String[] mapping =new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] dc=digits.toCharArray();
        for (int i=0;i<dc.length;i++){
            int k=Character.getNumericValue(dc[i]);//dc[i]也可以用digit.charat(i)
            while (ans.peek().length()==i){
                String s=ans.remove();
                for (char c:mapping[k].toCharArray()){
                    s=s+c;//String和Char是可以拼接的
                    ans.add(s);
                }
            }
        }
        return ans;
    }
}
