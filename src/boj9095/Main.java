package boj9095;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int[] resultArray = solve(t, arr);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < resultArray.length; i++) {
            result.append(resultArray[i]);
            if (i < resultArray.length - 1) {
                result.append("\n");
            }
        }
        writer.write(String.valueOf(result.toString()));

        reader.close();
        writer.flush();
        writer.close();
    }

    static int[] dp = new int[12];

    public int[] solve(int t, int ... n) {
        this.init();
        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            result[i] = dp[n[i]];
        }
        return result;
    }

    public void init() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
    }
}
