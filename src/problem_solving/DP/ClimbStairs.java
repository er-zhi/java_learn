package problem_solving.DP;

/**
 * Before starting to solve the problem, it's important to calculate the answers on paper based on the given inputs. This way, patterns may become apparent.
 * For example, here you can see the Fibonacci sequence,
 * which can be calculated using Dynamic Programming (DP
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n <= 2) return n;

        int first = 1;
        int second = 2;

        for(int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    // public int climbStairs(int n) {
    //     if (n < 0) return 0;
    //     if (n <= 2) return n;

    //     int[] fib = new int[n+1];
    //     fib[1] = 1;
    //     fib[2] = 2;

    //     for(int i = 3; i <= n; i++){
    //         fib[i] = fib[i-1] + fib[i-2];
    //     }

    //     return fib[n];
    // }
}
