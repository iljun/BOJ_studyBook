package boj1932;

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

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        long result = solve(n, arr);
        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public long solve(int n, int[][] arr) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }
        for (int i = n-2; i > -1; i--) {
            for (int j = 0; j < i+1; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];
            }
        }
        return dp[0][0];
    }
}
