package newcode.jiandan;

/**
 * 描述
 * 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
 * 2.如果不能获取到任何利润，请返回0
 * 3.假设买入卖出均无手续费
 *
 * 数据范围：0≤n≤10^5,0≤val≤10^4
 *
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 */


public class MaxProfit {

    public int maxProfit (int[] prices) {
        // write code here
        int res = 0;
        //排除特殊情况
        if(prices.length == 0)
            return res;
        //维护最低股票价格
        int Min = prices[0];
        //遍历后续股票价格
        for(int i = 1; i < prices.length; i++){
            //如果当日价格更低则更新最低价格
            Min = Math.min(Min, prices[i]);
            //维护最大值
            res = Math.max(res, prices[i] - Min);
        }
        return res;
    }
}
