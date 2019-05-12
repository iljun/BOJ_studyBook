package boj2156;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        long result = solve(n, arr);
        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(int n, int[] arr) {
        int[] dp = new int[n];
        if (n == 1) {
            return arr[0];
        }

        if (n == 2) {
            return arr[0] + arr[1];
        }

        if (n > 2) {
            dp[0] = arr[0];
            dp[1] = arr[0] + arr[1];
            dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
        }

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]), dp[i-1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
