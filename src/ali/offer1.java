package ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName offer1
 * Description TODO
 * @Author zwz
 * @Date 2020/4/1 15:52
 * @Version 1.0
 **/
public class offer1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        int[] res=new int[n];
        for (int i=0;i<n;i++){
            String[] str=sc.nextLine().split("");
            int[][] mat=new int[1][str.length];
            for (int j=0;j<str.length;j++){
                mat[0][j]=Integer.valueOf(str[j]);
            }
            res[i]=minFlips(mat);
        }
        for (int i=0;i<n;i++){
            if (res[i]==-1) {
                System.out.println("NO");
            }
            else{
                System.out.println(res[i]);
            }
        }
    }


    //下面这个是重新写的一个函数  上面这个是输入输出
    public static int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 存储每个位置需要被反转的次数，包括主动反转以及被动反转
        int[][] cnt = new int[m][n];
        // bit 为一行单元格的位压缩，limit 为 bit 的最大值
        int bit = 0, limit = (1 << n) - 1;
        int ans = 10;
        // 遍历每种状态
        while (bit <= limit) {

            // 初始化中间答案以及反转次数数组
            int tmp = 0;
            for (int i = 0; i < m; i++) {
                Arrays.fill(cnt[i], 0);
            }

            // 计算第一行
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) != 0) {
                    tmp++;
                    cnt[0][i]++;
                    if (m > 1) {
                        cnt[1][i]++;
                    }
                }
                // 考虑左右相邻格子对自身的影响
                if (i - 1 >= 0 && (bit & (1 << (i - 1))) != 0) {
                    cnt[0][i]++;
                }
                if (i + 1 < n && (bit & (1 << (i + 1))) != 0) {
                    cnt[0][i]++;
                }
            }

            // 递推后面的每一行
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 上一个单元格需要再次被反转的情况
                    if (mat[i - 1][j] == 0 && cnt[i - 1][j] % 2 == 1 || mat[i - 1][j] == 1 && cnt[i - 1][j] % 2 == 0) {
                        cnt[i][j]++;
                        if (i + 1 < m) {
                            cnt[i + 1][j]++;
                        }
                        tmp++;
                        if (j - 1 >= 0) {
                            cnt[i][j - 1]++;
                        }
                        if (j + 1 < n) {
                            cnt[i][j + 1]++;
                        }
                    }
                }
            }

            // 检测最后一行是否全为 0
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (mat[m - 1][i] == 0 && cnt[m - 1][i] % 2 == 1 || mat[m - 1][i] == 1 && cnt[m - 1][i] % 2 == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.min(ans, tmp);
            }
            bit++;
        }

        if (ans == 10) {
            return -1;
        } else {
            return ans;
        }
    }



}
