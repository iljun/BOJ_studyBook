package boj2579;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        int[] arr = new int[t + 1];
        for (int i = 1; i < t + 1; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int resultArray = solve(t, arr);
        writer.write(String.valueOf(resultArray));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(int t, int... n) {
        int[] sum = new int[t + 1];
        sum[1] = n[1];
        sum[2] = n[1] + n[2];
        for (int i = 3; i < t + 1; i++) {
            sum[i] = n[i] + Math.max(n[i-1] + sum[i-3], sum[i-2]);
        }
        return sum[t];
    }
}
