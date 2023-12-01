import java.util.*;

class Solution {
    
    public static String[][] operators = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split("")
    };

    public static long solution(String expression) {
        long answer = 0;
        List<String> tokens = createTokens(expression);
        for (String[] op : operators) {
            long result = Math.abs(calculate(new ArrayList<>(tokens), op));
            answer = Math.max(result, answer);
        }
        return answer;
    }

    private static long calculate(List<String> tokens, String[] operator) {

        for (String op : operator) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long num1 = Long.parseLong(tokens.get(i - 1));
                    long num2 = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(num1, num2, tokens.get(i));

                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i-=2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    private static List<String> createTokens(String expression) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        return tokens;
    }

    private static long calculate(long num1, long num2, String op) {
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
}