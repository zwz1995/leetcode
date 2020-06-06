package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName problem46
 * Description TODO
 * @Author zwz
 * @Date 2019/11/29 19:32
 * @Version 1.0
 **/
public class problem46 {
    public List<List<Integer>> permute(int[] nums){
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        boolean[] used=new boolean[len];
        if (len==0){
            return res;
        }
        dfs(nums,used,0,len,new Stack<>(),res);
        return res;
    }


    private void dfs(int[] nums, boolean[] visited, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
        if (curSize==len){
            res.add(new ArrayList<>(path));//
            return;
        }
        for (int i=0;i<len;i++){
            if (!visited[i]){
                path.push(nums[i]);
                visited[i]=true;
                dfs(nums,visited,curSize+1,len,path,res);
                path.pop();
                visited[i]=false;
            }
        }
    }
}
