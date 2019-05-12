package boj10828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0 ; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            Integer input = null;
            if (inputs[0].equalsIgnoreCase("push")) {
                input = Integer.parseInt(inputs[1]);
            }
            writer.write(String.valueOf(solve(inputs[0], input)));
        }
        reader.close();
        writer.flush();
        writer.close();
    }

    static List<Integer> stack = new ArrayList<>();

    public String solve(String command, Integer input) {
        Integer result = null;
        if (command.equalsIgnoreCase("push")) {
            stack.add(input);
        } else if (command.equalsIgnoreCase("pop")) {
            if (stack.size() == 0) {
                result = -1;
            } else {
                result = stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
            }
        } else if (command.equalsIgnoreCase("size")) {
            result = stack.size();
        } else if (command.equalsIgnoreCase("empty")) {
            if (stack.size() == 0) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (command.equalsIgnoreCase("top")) {
            if (stack.size() == 0) {
                result = -1;
            } else {
                result = stack.get(stack.size() - 1);
            }
        }

        if (result == null) {
            return "";
        }
        return result + "\n";
    }

}
