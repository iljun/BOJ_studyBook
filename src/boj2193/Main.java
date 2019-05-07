package boj2193;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        long result = solve(n);
        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public long solve(int n) {
        long[][] dp = new long[2][n+1];
        if (n == 1) {
            return 1;
        }
        // dp[0] -> 마지막이 0
        // dp[1] -> 마지막이 1
        dp[1][1] = dp[0][2] = 1;

        for (int i = 3; i < n+1; i++) {
            dp[0][i] = dp[1][i-1] + dp[0][i-1];
            dp[1][i] = dp[0][i-1];
        }

        return dp[0][n] + dp[1][n];
    }
}
