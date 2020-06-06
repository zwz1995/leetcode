package ainterview;

import linkedlist.ListNode;

import java.util.*;

/**
 * @ClassName Solution_1
 * Description TODO
 * @Author zwz
 * @Date 2020/3/24 18:01
 * @Version 1.0
 **/
public class Solution_1 {
    //之字打印二叉树
   public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
       ArrayList<ArrayList<Integer>> list=new ArrayList();
       if (pRoot==null) return list;
       Stack<TreeNode> l=new Stack();
       Stack<TreeNode> r=new Stack();
       l.push(pRoot);
       int flag=1;
       while (!l.empty()||!r.empty()){
           if(flag==1){
               ArrayList<Integer> a=new ArrayList();
               while (!l.empty()){
                   TreeNode t=l.pop();
                   a.add(t.val);
                   if(t.left!=null) r.push(t.left);
                   if(t.right!=null) r.push(t.right);
               }
               flag=0;
               list.add(a);
           }else{
               ArrayList<Integer> a=new ArrayList();
               while(!r.empty()){
                   TreeNode t=r.pop();
                   a.add(t.val);
                   if (t.left!=null) l.push(t.left);
                   if (t.right!=null) l.push(t.right);
               }
               flag=1;
               list.add(a);

           }
       }
       return list;
   }


  //序列化和反序列化
   int index=-1;
   String Serialize(TreeNode root){

       StringBuilder sb=new StringBuilder();
       if (root==null){
           sb.append("#,");
           return sb.toString();
       }
       sb.append(root.val+",");
       sb.append(Serialize(root.left));
       sb.append(Serialize(root.right));
       return sb.toString();
   }

   TreeNode Deserialize(String str){
       index++;
       String[] s=str.split(",");
       TreeNode node =null;
       if (!s[index].equals("#")){
           node.val=Integer.valueOf(s[index]);
           node.left=Deserialize(str);
           node.right=Deserialize(str);
       }
       return node;
   }


   //中序遍历
   ArrayList<Integer> list1=new ArrayList<Integer>();
   public void midOrder(TreeNode pRoot){
       if(pRoot==null) return;
       midOrder(pRoot.left);
       list1.add(pRoot.val);
       midOrder(pRoot.right);
   }



    //是否有这个路径
   public boolean hasPath(char[] matrix,int rows,int cols,char[]str){
       int[] flag=new int[matrix.length];
       for(int i=0;i<rows;i++){
           for (int j=0;j<cols;j++){
               if (helper(matrix,rows,cols,i,j,str,0,flag)){
                   return true;
               }
           }
       }
       return false;
   }

   private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
       int index=i*cols+j;
       if (i<0||i>=rows||j<0||j>=cols||matrix[index]!=str[k]||flag[index]==1){
           return false;
       }
       if (k==str.length-1) return true;
       flag[index]=1;
       if(helper(matrix,rows,cols,i+1,j,str,k+1,flag)||helper(matrix,rows,cols,i+1,j,str,k+1,flag)||helper(matrix,rows,cols,i+1,j,str,k+1,flag)||helper(matrix,rows,cols,i+1,j,str,k+1,flag)){
           return true;
       }
       flag[index]=0;
       return false;
   }

   //剪绳子 乘积最大
   public int cutRope(int target){
       if(target<=0) return 0;
       if(target==1) return 1;
       if (target==2) return 1;
       if (target==3) return 2;

       int[] dp=new int[target+1];
       dp[1]=1;
       dp[2]=2;
       dp[3]=3;
       for (int i=4;i<=target;i++){
           int res=0;
           for (int j=1;j<=i/2;j++){
               res=Math.max(res,dp[j]+dp[i-j]);
           }
           dp[i]=res;
       }
       return dp[target];
   }


    //有序二维数组找数
    public boolean Find(int target,int[][] array){
       int row=0;
       int col=array[0].length-1;
       while(row<=array.length-1&&col>=0){
           if(target==array[row][col]){
               return true;
           }else if (target>array[row][col]){
               row++;
           }else
               col--;
       }
       return false;
    }

    //两个数组分别是pop和push  是否符合
    public boolean isPopOrder(int[] pushA,int[] popA){
       if(pushA.length==0||popA.length==0) return false;
       Stack<Integer> s=new Stack();
       int popIndex=0;
       for (int i=0;i<pushA.length;i++){
           s.push(pushA[i]);
           while (!s.empty()&&s.peek()==pushA[popIndex]){
               s.pop();
               popIndex++;
           }
       }
       return s.empty();
    }


    //打印最小的数字
    public String PringtMinNumber(int[] numbers){
       if (numbers==null||numbers.length==0) return "";
       int len=numbers.length;
       String[] str=new String[len];
       StringBuilder sb=new StringBuilder();
       for (int i=0;i<len;i++){
           str[i]=String.valueOf(numbers[i]);
       }
       Arrays.sort(str, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               String c1=o1+o2;
               String c2=o2+o1;
               return c1.compareTo(c2);
           }

       });
       for (int i=0;i<len;i++){
           sb.append(str[i]);
       }
       return sb.toString();
    }


    //分糖果
    public int LastRemaining(int n,int m){
       if(n<1||m<1) return -1;
       int[] array=new int[n];
       int i=-1,step=0,count=n;
       while(count>0){
           i++;
           if(i>n) i=0;
           if (array[i]==-1) continue;
           step++;
           if (step==m){
               array[i]=-1;
               step=0;
               count--;
           }
       }
       return i;
    }

    //dp走路
    public int uniquePaths(int m,int n){
       if(m==0||n==0) return 0;
       int[] dp=new int[n];
       dp[0]=1;
       for (int i=0;i<n;i++){
           for (int j=0;j<m;j++){
               if (i==0) dp[j]=1;
               else dp[j]=dp[j-1]+dp[j];
           }
       }
       return dp[m-1];
    }


//    s1和s2能否组成s3
//    s1 = "aabcc",
//    s2 = "dbbca",
//
//    When s3 = "aadbbcbcac", return true.
   public boolean isInterleave(String s1,String s2,String s3){
       if(s1==null||s2==null||s3==null) return false;
       if(s1.length()+s2.length()!=s3.length()) return false;
       boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
       dp[0][0]=true;
       for (int i=1;i<=s1.length();i++){
           if (s1.charAt(i-1)==s3.charAt(i-1)&&dp[i-1][0]){
               dp[i][0]=true;
           }
       }
       for (int j=1;j<=s1.length();j++){
           if(s2.charAt(j-1)==s3.charAt(j-1)&&dp[0][j-1]){
               dp[0][j]=true;
           }
       }
       for (int i=1;i<=s1.length();i++){
           for (int j=1;j<=s2.length();j++){
               if (s1.charAt(i-1)==s3.charAt(i+j-1)&&dp[i-1][j]){
                   dp[i][j]=true;
               }
               if (s2.charAt(j-1)==s3.charAt(i+j-1)&&dp[i][j-1]){
                   dp[i][j]=true;
               }
           }
       }
       return dp[s1.length()][s2.length()];
   }


    //edit distarce
    public int minDistance(String word1,String word2){
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[n+1][m+1];
        dp[0][0]=0;
        for (int i=1;i<=n;i++){
            dp[i][0]=dp[i-1][0]+1;
        }
        for (int j=1;j<=m;j++){
            dp[0][j]=dp[0][j-1]+1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }

    //每k个一组反转链表
    public ListNode reverseGroup(ListNode head,int k){
        if (head==null||head.next==null||k<1){
            return head;
        }
        ListNode currentNode =head;
        for (int count=1;count<k;count++){
            currentNode=currentNode.next;
            if (currentNode==null) return head;
        }
        ListNode next=currentNode.next;
        reverse(head,currentNode);
        head.next=reverseGroup(next,k);
        return currentNode;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
       if (head==null||head.next==null){
           return head;
       }
       ListNode pre=null;

       while (head!=tail){
           ListNode temp=head.next;
           head.next=pre;
           pre=head;
           head=temp;

       }
       return pre;
    }



    //二分
    public void erFen(int[] nums,int target){
       int l=0;
       int r=nums.length-1;
       while (l<r){
           int m=l+r>>1;
           if(nums[m]>=target){
               r=m;
           }else{
               l=m+1;
           }
       }
        System.out.println(l);
    }

    public void erFen1(int[] nums,int target){
        int l=0;
        int r=nums.length-1;
        while (l<r){
            int m=l+r+1>>1;
            if (nums[m]>target){
                r=m-1;
            }else{
                l=m;
            }
        }
    }

    //双端链表和栈--中间输出 addlast  addfirst polllast pollfirst
    public void  zhongJian(ListNode head){
       if (head==null) return;
       ArrayDeque<ListNode> q=new ArrayDeque<ListNode>();
       Stack<ListNode> s=new Stack();
       while (head!=null){
           q.addLast(head);
           head=head.next;
       }
       while (!q.isEmpty()){
           s.add(q.pollLast());
           s.add(q.pollFirst());
       }
       while (!s.isEmpty()){
           System.out.println(s.pop().val);
       }
    }


    //中序遍历非递归
    public List<TreeNode> inorderTraversal(TreeNode root){
       List<TreeNode> list=new ArrayList<>();
       TreeNode temp=root;
       Stack<TreeNode> s=new Stack<>();
       while (temp!=null||!s.isEmpty()){
           while (temp.left!=null){
               s.add(temp);
               temp=temp.left;
           }
           temp=s.pop();
           list.add(temp);
           temp=temp.right;
       }
       return list;
    }

    //股票问题1
    public int maxProfit1(int[] prices){
        int n=prices.length;
        int maxProfit=0;
        int min=prices[0];
        for (int i=0;i<n;i++){
            min=Math.min(prices[i],min);
            maxProfit=Math.max(maxProfit,prices[i]-min);
        }
        return maxProfit;
    }

    //股票问题2
    public int maxProfitVla(int[] prices){
       int n=prices.length;
       if(n<2) return 0;
       int[] preProfit=new int[n];
       int[] postProfit=new int[n];

       int curMin=prices[0];
       for (int i=0;i<n;i++){
           curMin=Math.min(curMin,prices[i]);
           preProfit[i]=Math.max(preProfit[i-1],prices[i]-curMin);
       }

       int curMax=prices[n-1];
       for (int i=n-2;i>=0;i--){
           curMax=Math.max(curMax,prices[i]);
           postProfit[i]=Math.max(postProfit[i+1],curMax-prices[i]);
       }
       int maxProfit = 0;
       for (int i=0;i<n;i++){
           maxProfit=Math.max(maxProfit,preProfit[i]+postProfit[i]);
       }
       return maxProfit;
    }



    //统计有序数组里平方和的数目
    public static int DifferentMi(int nums[]){
        int cnt=0;
        int i=0,j=nums.length-1;
        while(i<j){
            while(i<j && nums[i]*nums[i]==nums[j]*nums[j])
                i++;
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                while(i<j && nums[i]*nums[i]==nums[i+1]*nums[i+1])
                    i++;
                i++;
            }else{
                while(i<j && nums[j]*nums[j]==nums[j-1]*nums[j-1])
                    j--;
                j--;
            }
            cnt++;
        }
        return cnt;
    }

    //孩子们的圆圈问题
    public int LastRemaining_Solution(int n, int m){
       if(n<1||m<1) return -1;
       int[] flag=new int[n];
       int count=n,i=-1,step=0;
       while (count==0){
           i++;
           if (i==n) i=0;
           if (flag[i]==1) continue;
           step++;
           if (step==m){
               flag[i]=1;
               step=0;
               count--;
           }
       }
       return i;
    }


    //滑动窗口
    public ArrayList<Integer> maxInWindows(int [] num, int size){
       ArrayList<Integer> result=new ArrayList<Integer>();
       if (size<1) return result;
       int begin;
       ArrayDeque<Integer> deque=new ArrayDeque<Integer>();
       for (int i=0;i<num.length;i++){
           begin=i-size+1;
           if (deque.isEmpty()){
               deque.addLast(i);
           }else if (deque.peekFirst()<begin){
               deque.pollFirst();
           }
           while (!deque.isEmpty()&&num[deque.peekLast()]<=num[i]){
               deque.pollLast();
           }
           deque.addLast(i);
           if (begin>=0){
               result.add(num[deque.peekFirst()]);
           }

       }
       return result;
    }
}


