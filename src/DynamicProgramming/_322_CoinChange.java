package DynamicProgramming;

import java.util.Arrays;

public class _322_CoinChange {
	public static void main(String[] args) {
		_322_CoinChange instance = new _322_CoinChange();
		int[] coins = {2};
		int amount = 3;
		int res = instance.coinChange(coins, amount);
		System.out.print(res);
	}

	/*
	 * Method 1
	 */
	public int coinChange(int[] coins, int amount) {
		return coinChange(0, coins, amount);
	}
	
	private int coinChange(int idxCoin, int[] coins, int amount) {
		if(amount == 0) {
			return 0;
		}
		if(idxCoin < coins.length && amount > 0) {
			int maxNum = amount / coins[idxCoin];
			int minCost = Integer.MAX_VALUE;
			for(int i=0; i<=maxNum; i++) {
				if(amount >= i * coins[idxCoin]) {
					int res = coinChange(idxCoin+1, coins, amount-i*coins[idxCoin]);
					if(res != -1) {
						minCost = Math.min(minCost, res + i);
					}
				}
			}
			return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
		}
		return -1;
	}
	
	/*
	 * Method 2. Dynamic Programming, Top Down
	 */
	public int coinChange1(int[] coins, int amount) {
		if(amount < 1) {
			return 0;
		}
		return coinChange(coins, amount, new int[amount]);
	}
	
	private int coinChange(int[] coins, int rem, int[] count) {
		if(rem < 0) {
			return -1;
		}
		if(rem == 0) {
			return 0;
		}
		if(count[rem-1] != 0) {
			return count[rem-1];
		}
		int min = Integer.MAX_VALUE;
		for(int coin: coins) {
			int res = coinChange(coins, rem-coin, count);
			if(res >= 0 && res < min) {
				min = 1 + res;
			}
		}
		count[rem-1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem-1];
	}
	
	/*
	 * Method 3. DP, bottom up
	 */
	public int coinChange2(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount+1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for(int i=1; i<=amount; i++) {
			for(int j=0; j<coins.length; j++) {
				if(coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
	
	/*
	 * Method 4. 
	 */
    public int coinChange3(int[] coins, int amount) {
        Arrays.sort(coins);
       
        dfs(coins, amount, coins.length - 1, 0);
        return (res == Integer.MAX_VALUE ? -1 : res);
    }
    int res = Integer.MAX_VALUE;
    void dfs(int[] coins, int amount, int idx, int count) {
        if (idx < 0) {
            return;
        }
        if (amount % coins[idx] == 0) {
            res = Math.min(res, count + amount / coins[idx]);
            return;
        }
        
        for (int i = amount / coins[idx]; i >= 0 ; --i) {
            if (count + i >= res - 1) {
                break;
            }
            dfs(coins, amount - i * coins[idx] , idx - 1, count + i);
        }
    }
	
}
