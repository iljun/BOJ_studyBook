package boj9012;

import java.io.*;
import java.util.List;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0 ; i < n; i++) {
            String input = reader.readLine();
            writer.write(String.valueOf(solve(input)) + "\n");
        }
        reader.close();
        writer.flush();
        writer.close();
    }

    static final String YES = "YES";

    static final String NO = "NO";

    public String solve(String input) {
        Stack<String> stack = new Stack<>();
        String[] splitArray = input.split("");
        for (String bracket : splitArray) {
            if (bracket.equalsIgnoreCase("(")) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return NO;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return YES;
        }
        return NO;
    }
}
