package ainterview;

import java.util.*;

/**
 * @ClassName Leetcode13
 * Description TODO
 * @Author zwz
 * @Date 2020/4/2 10:31
 * @Version 1.0
 **/

public class Solution_2 {
    //罗马串转整数
    public int romanToInt(String s) {
        if(s.length()==0) return 0;
        int sum=0;
        int i=0;
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        if (s.length()==1){
            return map.get(s.charAt(i));
        }
        while (i<s.length()-1){
            if (s.charAt(i)=='I'&&(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')){
                sum+=map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i+=2;
            }else if (s.charAt(i)=='X'&&(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')){
                sum+=map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i+=2;
            }else if (s.charAt(i)=='C'&&(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')){
                sum+=map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i+=2;
            }else{
                sum+=map.get(s.charAt(i));
                i++;
            }
        }
        if (i==s.length()){
            return sum;
        }else{
            return sum+map.get(s.charAt(i));
        }
    }

    //有序数组转二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return helper(nums,0,nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start>end) return null;
        if (start==end) return new TreeNode(nums[start]);
        int m=(start+end)/2;
        TreeNode t=new TreeNode(nums[m]);
        t.left=helper(nums,start,m-1);
        t.right=helper(nums,m+1,end);
        return t;
    }



    //自定义字符串转整数
    public int titleToNumber(String s) {
        //  ascii码-64为原值
        int sum=0;
        int p=1;
        for (int i=s.length()-1;i>=0;i--){
            sum+=(s.charAt(i)-64)*p;
            p*=26;
        }
        return sum;
    }

    //是否是回文
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int head=0,tail=s.length()-1;
        char cHead,cTail;
        while(head<=tail){
            cHead=s.charAt(head);
            cTail=s.charAt(tail);
            if(!Character.isLetterOrDigit(cHead)){
                head++;
            }else if (!Character.isLetterOrDigit(cTail)){
                tail--;
            }else{
                if(Character.toLowerCase(cHead)!=Character.toLowerCase(cTail)){
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }


    //二叉树最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return root;
        if(p==root||q==root) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left!=null&&right!=null){
            return root;
        }else if (left!=null){
            return left;
        }else if (right!=null){
            return right;
        }
        return null;

    }

    //二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        if (root==null) return result;
        helper1(result,root,"");
        return result;
    }

    private void helper1(List<String> result, TreeNode root, String temp) {
        if (root==null) return;
        temp+=root.val;
        if (root.left==null&&root.right==null) {
            result.add(temp);
        }else{
            helper1(result,root.left,temp+"->");
            helper1(result,root.right,temp+"->");
        }
    }

    //路径总和1
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) return false;
        if (root.left==null&&root.right==null){
            if (sum-root.val==0){
                return true;
            }
            return false;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    //路径总和2
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper2(result,root,sum,temp);
        return result;
    }

    private void helper2(List<List<Integer>> result, TreeNode root, int sum, List<Integer> temp) {
        if (root==null) return;
        temp.add(root.val);
        if (root.left==null&&root.right==null&&sum==root.val){
            result.add(new ArrayList<>(temp));
        }else{
            helper2(result,root.left,sum-root.val,temp);
            helper2(result,root.right,sum-root.val,temp);
        }
        temp.remove(temp.size()-1);

    }

    //组合求和
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(candidates);
        helper3(result,temp,candidates,target,0);
        return result;
    }

    private void helper3(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {
        if (target<0){
            return;
        }else if (target==0){
            result.add(new ArrayList<>(temp));
        }else{
            for (int i=start;i<candidates.length;i++){
                temp.add(candidates[i]);
                helper3(result,temp,candidates,target-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }

    //组合求和2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(candidates);
        helper4(result,temp,candidates,target,0);
        return result;
    }

    private void helper4(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {
        if (target<0){
            return;
        }else if (target==0){
            result.add(new ArrayList<>(temp));
        }else{
            for (int i=start;i<candidates.length;i++){
                if (i>start&&candidates[i]==candidates[i-1]) continue;
                temp.add(candidates[i]);
                helper4(result,temp,candidates,target-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }

    //计算原子的数量
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String,Integer>> stack = new Stack<>();
        //curMap对字符串进行遍历
        TreeMap<String , Integer> curMap = new TreeMap<>();
        int len = formula.length();
        for(int i=0 ; i<len ;){
            char c = formula.charAt(i);
            if(c=='('){
                stack.push(curMap);
                //新建map对括号里面字符串进行操作
                curMap = new TreeMap<>();
                i++;
            }else if(c==')'){
                //两个treemap合并
                //当前treemap保存下来
                TreeMap<String , Integer> temp = curMap;
                curMap = stack.pop();
                i++;
                int istart = i;
                int quantity = 1;
                while(i<len && Character.isDigit(formula.charAt(i))) i++;
                if(istart<i){
                    quantity = Integer.parseInt(formula.substring(istart,i));
                }
                for(String name : temp.keySet()){
                    curMap.put(name , curMap.getOrDefault(name,0) + temp.get(name)*quantity);
                }
            }else{
                int istart = i;
                i++;
                while(i<len && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(istart,i);
                istart = i;
                int quantity = 1;
                while(i<len && Character.isDigit(formula.charAt(i))) i++;
                if(istart<i){
                    quantity = Integer.parseInt(formula.substring(istart,i));
                }
                curMap.put(name , curMap.getOrDefault(name,0) + quantity);
            }
        }
        StringBuilder sb =new StringBuilder();
        for(String name : curMap.keySet()){
            int quantity = curMap.get(name);
            sb.append(name);
            if(quantity>1){
                sb.append(quantity);
            }
        }
        return sb.toString();
    }
    //优先队列使用
    public void queue(){
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

    }



    public static void main(String[] args) {
        System.out.println(new Solution_2().titleToNumber("AA"));
    }

}
