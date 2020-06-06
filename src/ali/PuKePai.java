package ali;

public class PuKePai {
    public static int min = Integer.MAX_VALUE;
    public static boolean check(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static void dfs(int[] nums, int count) {
        //剪枝
        if(count>min)
        {
            return;
        }
        if (check(nums)) {
            int i = 0;
            while (nums[i] == 0) {
                i++;
            }
            //单张
            if (nums[i] > 0) {
                nums[i]--;
                dfs(nums, count+1);
                nums[i]++;
            }
            //对子
            if (nums[i] > 1) {
                nums[i] -= 2;
                dfs(nums,count+1);
                nums[i] += 2;
            }
            //五连
            if (i + 5 <= nums.length && nums[i] > 0 && nums[i + 1] > 0 && nums[i + 2] > 0 && nums[i + 3] > 0 && nums[i + 4] > 0) {
                for (int j = 0; j < 5; j++) {
                    nums[i + j]--;
                }
                dfs(nums, count+1);
                for (int j = 0; j < 5; j++) {
                    nums[i + j]++;
                }
            }
            //三双
            if (i + 3 <= nums.length && nums[i] > 1 && nums[i + 1] > 1 && nums[i + 2] > 1) {
                nums[i] -= 2;
                nums[i + 1] -= 2;
                nums[i + 2] -= 2;
                dfs(nums, count+1);
                nums[i] += 2;
                nums[i + 1] += 2;
                nums[i + 2] += 2;
            }
        } else {
            if(count<min)
            {
                min = count;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 4, 2, 1, 2, 2, 3, 2, 4};
        dfs(nums, 0);
        System.out.println(min);
    }
}
