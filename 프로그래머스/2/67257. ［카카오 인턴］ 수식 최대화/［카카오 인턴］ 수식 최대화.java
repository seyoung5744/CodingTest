import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static final String[] operators = {
        "+-*",
        "+*-",
        "-+*",
        "-*+",
        "*+-",
        "*-+"
    };

    public static long solution(String expression) {
        long answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        for (String operator : operators) {
            List<String> original = new ArrayList<>(tokens);
            for (String op : operator.split("")) {
                original = calculate(original, op);
            }

            answer = Math.max(answer, Math.abs(Long.parseLong(original.get(0))));
        }

        return answer;
    }

    public static List<String> calculate(List<String> tokens, String op) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals(op)) {
                long num1 = Long.parseLong(result.get(result.size() - 1));
                String operator = tokens.get(i);
                long num2 = Long.parseLong(tokens.get(i + 1));
                result.remove(result.size() - 1);
                result.add(String.valueOf(calculate(num1, num2, operator)));
                i++;
            } else {
                result.add(tokens.get(i));
            }
        }
        return result;
    }

    public static long calculate(long a, long b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
        }
        return 0;
    }
}
