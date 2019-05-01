package boj1003;

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

        int[][] resultArray = solve(t, arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < t + 1; i++) {
            stringBuilder.append(String.valueOf(resultArray[0][arr[i]])).append(" ").append(String.valueOf(resultArray[1][arr[i]])).append("\n");
        }
        writer.write(stringBuilder.toString());

        reader.close();
        writer.flush();
        writer.close();
    }

    public int[][] solve(int t, int... n) {
        this.init();
        return arr;
    }

    static int N = 41;
    static int[][] arr = new int[2][N];
    public void init() {
        arr[0][0] = arr[1][1] = 1;
        for (int i = 2; i < N; i++) {
            arr[0][i] = arr[0][i-1] + arr[0][i-2];
            arr[1][i] = arr[1][i-1] + arr[1][i-2];
        }
    }
}
