package Array;

public class _121_BestTimeToBuyAndSellStock {
	/*
	 * Method 1
	 * Two loop
	 */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for(int i=0; i<prices.length-1; i++) {
            for(int j=i+1; j<prices.length; j++) {
                int profit = prices[j] - prices[i];
                if(profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
    
    /*
     * Method 2
     */
    public int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < minprice) {
                minprice = prices[i];
            } else if(prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
    
    /*
     * Method 3
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
