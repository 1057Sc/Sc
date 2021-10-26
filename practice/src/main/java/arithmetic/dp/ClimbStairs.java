package arithmetic.dp;

/**
 * 经典青蛙爬楼梯问题
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(getMethodNums(4));
    }

    public static int getMethodNums(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }


    public static int getMethodNumsO1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int pre = 1;
        int cur = 2;
        for (int i = 2; i < n; i++) {
           int temp = pre + cur;
            pre = cur;
            cur = temp;
        }

        return cur;
    }
}
