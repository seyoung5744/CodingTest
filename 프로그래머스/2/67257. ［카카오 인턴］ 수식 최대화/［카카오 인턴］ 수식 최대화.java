import java.util.*;

class Solution {
    public static final String[] operations = {
            "+-*",
            "+*-",
            "-+*",
            "-*+",
            "*+-",
            "*-+"
    };

    public long solution(String expression) {
        long answer = 0;

        for (String operation : operations) {
            List<String> tokens = split(expression);
            for (char c : operation.toCharArray()) {
                String op = String.valueOf(c);

                for (int i = 0; i < tokens.size(); i++) {
                    if (op.equals(tokens.get(i))) {
                        long num1 = Long.parseLong(tokens.get(i - 1));
                        long num2 = Long.parseLong(tokens.get(i + 1));
                        long result = calculate(num1, num2, tokens.get(i));

                        tokens.remove(i);
                        tokens.remove(i);

                        tokens.set(i - 1, String.valueOf(result));
                        i--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(tokens.get(0))));
        }

        return answer;
    }

    public long calculate(long num1, long num2, String op) {
        long result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
        }
        return result;
    }

    public List<String> split(String expression) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        return tokens;
    }
}