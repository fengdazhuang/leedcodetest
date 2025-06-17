package com.fzz.way1.贪心算法;

public class Test122 {
    public static void main(String[] args) {
        int[] prices={1,2,3,4,5};
        int i = new Solution122().maxProfit(prices);
        System.out.println(i);

    }
}

class Solution122 {
    public int maxProfit(int[] prices) {
        /*int buyPrice=0;
        int sum=0;
        boolean flag=true;
        for(int i=0;i<prices.length;i++){
            if(i+1<prices.length&&prices[i]<prices[i+1]&&flag){
                buyPrice=prices[i];
                flag=false;
            }
            if(i+1<prices.length&&prices[i]>prices[i+1]&& !flag){
                sum+=prices[i]-buyPrice;
                flag=true;
            }
        }
        if(!flag){
            sum+=prices[prices.length-1]-buyPrice;
        }

        return sum;*/

        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
