package jiandan;

import sun.nio.cs.ext.MacThai;

import java.security.Signature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.jar.JarEntry;

public class BagQuestions {

    /**
     * 给定n种物品和一个容量为C的背包，物品i的重量是wi，其价值为vi。问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？
     * 使用动态规划，阶段就是“物品的件数”，状态就是“背包剩下的容量”，那么很显然 f[i,v] 就设为从前i件物品中选择放入容量为j的背包最大的价值。那么状态转移方程为：
     *
     * f[i][j]=max(f[i−1][j],f[i−1][j−w[i]]+c[i])
     */
    int OneZeroBags(int[] weights, int[] values, int capacity, int n){
        int[][] dp = new int[n+1][capacity+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<capacity+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else{
                    if(j>=weights[i-1]){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][capacity];
    }

    /**
     *优化用1维数组解决01背包问题
     */
    int OneZeroBags2(int[] weights, int[] values, int capacity, int n){
        int[] dp = new int[capacity+1];
        for(int i=0;i<n;i++){
            for(int j=capacity;j>=weights[i];j--){
                dp[j] = Math.max(dp[j], dp[j-weights[i]]+values[i]);
            }
        }
        return dp[capacity];
    }

    /**
     *有N种物品和一个容量为C的背包，每种物品都有无限件可用。第i种物品的费用是w[i]，价值是v[i]。
     * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     */
    int FullBangQuestions(int[] weights, int[] values, int capacity, int n){
        int[][] dp = new int[n+1][capacity+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<capacity+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else{
                    if(j>=weights[i-1]){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weights[i-1]]+values[i-1]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][capacity];
    }

    /**
     *可重复取的物品按取k次尝试计算。
     */
    int MultiBagQuestions(int[] weights, int[] values, int[] nums, int capacity, int n){
        int[] dp = new int[capacity+1];
        for(int i=0;i<n;i++){
            for(int j=capacity;j>=weights[i];j--){
                for(int k=1;k<=nums[i]&&k*weights[i]<=j;k++){
                    dp[j] = Math.max(dp[j], dp[j-k*weights[i]]+k*values[i]);
                }
            }
        }
        return dp[capacity];
    }

    /**
     * 可以重复取的物品按照个数展开，放进物品和权重的数组，然后按照正常01背包问题解决。
     */
    int MultiBagQuestions2(Integer[] weights, Integer[] values, Integer[] nums, int capacity, int n){
        List<Integer> nweights = new ArrayList<>(Arrays.asList(weights));
        List<Integer> nvalues = new ArrayList<>(Arrays.asList(values));
        for(int i=0;i<nums.length;i++){
            while(nums[i]>1){
                nweights.add(weights[i]);
                nvalues.add(values[i]);
                nums[i]--;
            }
        }
        int[] dp = new int[capacity+1];
        for(int i=0;i<nweights.size();i++){
            for(int j=capacity;j>= nweights.get(i);j--){
                dp[j] = Math.max(dp[j], dp[j - nweights.get(i)] + nvalues.get(i));
            }
        }

        return dp[capacity];
    }

    /**
     *有 N 种物品和一个容量是 V 的背包。
     *
     * 物品一共有三类：
     *
     * 第一类物品只能用1次（01背包）；
     * 第二类物品可以用无限次（完全背包）；
     * 第三类物品最多只能用 sisi 次（多重背包）；
     * 每种体积是 vi，价值是 wi。
     *
     * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
     * 输出最大价值。
     *
     * 输入格式
     *
     * 第一行两个整数，N，V用空格隔开，分别表示物品种数和背包容积。
     *
     * 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
     *
     * si=−1 表示第 i 种物品只能用1次；
     * si=0 表示第 i 种物品可以用无限次；
     * si>0表示第 i 种物品可以使用 si 次；
     * 输出格式
     *
     * 输出一个整数，表示最大价值。
     *
     * 数据范围
     *
     * 0<N,V≤1000
     * 0<vi,wi≤1000
     * −1≤si≤1000
     *
     * 输入样例
     *
     * 4 5
     * 1 2 -1
     * 2 4 1
     * 3 4 0
     * 4 5 2
     * 输出样例：
     *
     * 8
     *
     *
     * 解法：
     * 混合背包问题用前面完全背包问题的解法，把物品可使用次数分成二进制位表示(可重复使用的物品展开成二进制表示的使用次数的物品，
     * 生成新的物品和价值数组，然后按照完全和01背包问题解决。)，
     * 数组v[i]存容量，数组w[i]存容量对应的价值，s[i]存类型，完全背包类型容量从前往后遍历，01背包和多重背包问题从后往前遍历
     */

    int hybidBagQuestions(Integer[] v, Integer[] w, Integer[] s, int volume, int n){
        List<Integer> nv = new ArrayList<>();
        List<Integer> nw = new ArrayList<>();
        List<Integer> ns = new ArrayList<>();
        int total = 0;
        for(int i=0;i<n;i++){
            if(s[i] == -1){
                nv.add(v[i]);
                nw.add(w[i]);
                ns.add(-1);
            }else if(s[i] ==0){
                nv.add(v[i]);
                nw.add(w[i]);
                ns.add(0);
            }else {
                for(int j=1;j<s[i];j<<=1){
                    nv.add(j*v[i]);
                    nw.add(j*w[i]);
                    ns.add(s[i]);
                    s[i] -= j;
                }

                if(s[i] >0){
                    nv.add(s[i]*v[i]);
                    nw.add(s[i]*w[i]);
                    ns.add(s[i]);
                }
            }
        }
        int[] dp = new int[nw.size()+1];
        for(int i=0;i<nw.size();i++){
            if(ns.get(i) == 0){
                for(int j= nv.get(i);j<=volume;j++){
                    dp[j] = Math.max(dp[j], dp[j-nv.get(i)]+nw.get(i));
                }
            }else {
                for(int j=volume;j>=nv.get(i);j--){
                    dp[j] = Math.max(dp[j], dp[j-nv.get(i)]+nw.get(i));
                }
            }
        }

        return dp[volume];
    }

    /**
     *有 N 件物品和一个容量是 V 的背包，背包能承受的最大重量是 M。
     *
     * 每件物品只能用一次。体积是 vi，重量是 mi，价值是 wi。
     *
     * 求解将哪些物品装入背包，可使物品总体积不超过背包容量，总重量不超过背包可承受的最大重量，且价值总和最大。
     * 输出最大价值。
     *
     * 输入格式
     * 第一行三个整数，N,V,M，用空格隔开，分别表示物品件数、背包容积和背包可承受的最大重量。
     *
     * 接下来有 N 行，每行三个整数 vi,mi,wi，用空格隔开，分别表示第 i 件物品的体积、重量和价值。
     *
     * 输出格式
     * 输出一个整数，表示最大价值。
     *
     * 数据范围
     * 0<N≤1000
     * 0<V,M≤100
     * 0<vi,mi≤100
     * 0<wi≤1000
     *
     *     //N为物品数目
     *     //V为背包的第一种容量
     *     //U为背包的第二种容量
     *     //cost1[]为每个物品所需要的第一种费用
     *     //cost2[]为每个物品所需要的第二种费用
     *     //value[]为每个物品的价值
     */
    int twoDemensionBag(int[] cost1, int[] cost2, int[] values, int n, int v,int u){
        int[][] dp = new int[v+1][u+1];

        for(int i=1;i<=n;i++){
            int c=cost1[i-1], d = cost2[i-1], val = values[i-1];
            for(int j=v;j>=c;j--){
                for(int k=u;k>=d;k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j-c][k-d]+v);
                }
            }
        }
        return dp[v][u];
    }

}
