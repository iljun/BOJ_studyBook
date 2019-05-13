package boj10799;

import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();
        long result = solve(input);
        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    static final String openBracket = "(";

    static final String closeBracket = ")";

    public long solve(String input) {
        // initialize
        Stack<String> sticks = new Stack<>();
        String[] bracketArrays = input.split("");
        long result = 0;

        for (int i = 0; i < bracketArrays.length; i++) {
            if (bracketArrays[i].equalsIgnoreCase(openBracket)) {
                sticks.push(openBracket);
            } else {
                sticks.pop();
                if(bracketArrays[i-1].equalsIgnoreCase(openBracket)) {
                    result += sticks.size();
                } else {
                    result++;
                }
            }
        }
        return result;
    }
}
