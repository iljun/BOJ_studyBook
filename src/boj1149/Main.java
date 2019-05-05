package boj1149;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int result = solve(n, arr);
        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    static final int RED  = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public int solve(int n, int[][] arr) {
        int[][] dp = new int[n][3];

        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][RED] = Math.min(dp[i-1][GREEN], dp[i-1][BLUE]) + arr[i][RED];
            dp[i][GREEN] = Math.min(dp[i-1][RED], dp[i-1][BLUE]) + arr[i][GREEN];
            dp[i][BLUE] = Math.min(dp[i-1][RED], dp[i-1][GREEN]) + arr[i][BLUE];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }
}
