package nowcoder;

import java.util.ArrayList;

/**
 * @ClassName PaiLie
 * Description TODO
 * @Author zwz
 * @Date 2020/3/24 15:33
 * @Version 1.0
 **/
public class PaiLie {
    private  ArrayList<ArrayList<Character>> res=new ArrayList<>();
    public ArrayList<String> paiLie(String str){
        ArrayList<Character> select=new ArrayList();
        if (str.length()>0&&str!=null){
            helper(select,str.toCharArray(),0);
        }
        return null;
    }

    private void helper(ArrayList<Character> select, char[] ch, int pos) {
        if (pos==ch.length){
            res.add(new ArrayList<>(select));
            return;
        }
        for (int i=0;i<ch.length;i++){
            if (!select.contains(ch[i])){
                select.add(ch[i]);
                helper(select,ch,pos+1);
                select.remove(select.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        new PaiLie().paiLie("abc");
    }
}
