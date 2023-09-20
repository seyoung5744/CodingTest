import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split("")
    };

    public long solution(String expression) {
        long max = 0;
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        
        for(String[] precedence : precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if(value > max){
                max = value;
            }
        }
        return max;
    }

    private static long calculate(long num1, long num2, String operation) {
        long result = 0;

        switch (operation) {
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

    private static long calculate(List<String> tokens, String[] precedence) {

        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long num1 = Long.parseLong(tokens.get(i - 1));
                    long num2 = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(num1, num2, op);

                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }

        return Long.parseLong(tokens.get(0));
    }
}
