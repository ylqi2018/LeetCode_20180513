package DynamicProgramming;

public class _121_BestTimeBuyAndSellStock {

	/*
	 * Method 1.
	 */
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int minVal = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] < minVal) {
                minVal = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - minVal);
            }
        }
        return profit;
    }
    
    /*
     * Method 2.
     */
    public int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
