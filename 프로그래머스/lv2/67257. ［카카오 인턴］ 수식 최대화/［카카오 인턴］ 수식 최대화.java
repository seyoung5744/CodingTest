import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private static final String[][] precedences =
        {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split("")
        };

    public long solution(String expression) {
        List<String> tokens = new ArrayList<>();

        String strNum = "";
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                strNum += c;
            } else {
                tokens.add(strNum);
                tokens.add(String.valueOf(c));
                strNum = "";
            }
        }
        tokens.add(strNum);

        long answer = 0;
        for(String[] precedence : precedences) {
            answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(tokens), precedence)));
        }

        return answer;
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
}
