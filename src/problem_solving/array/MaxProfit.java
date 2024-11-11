package problem_solving.array;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize to the highest possible value
        int maxProfit = 0; // No profit at the start

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit; // Return the maximum profit found
    }
}

/*
Time Complexity: 𝑂(𝑛)

 Day   Price   minPrice   Profit (price - minPrice)   maxProfit
 1     7       7          -                           0
 2     1       1          -                           0
 3     5       1          5 - 1 = 4                   4
 4     3       1          3 - 1 = 2                   4
 5     6       1          6 - 1 = 5                   5
 6     4       1          4 - 1 = 3                   5
 */
