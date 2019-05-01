package boj1463;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int result = solve(n);

        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }

        return dp[n];
    }
}
