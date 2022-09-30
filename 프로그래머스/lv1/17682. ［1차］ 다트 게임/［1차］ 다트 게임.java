import java.util.*;

class Solution {
    public static String isDesimal(String num1, String num2){
        if(isNumber(num1+num2)){
            return num1+num2;
        }
        return num1;
    }
    public static boolean isNumber(String num){
        try{
            Integer.parseInt(num);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Double> scores = new Stack<>();
        String[] chars = dartResult.split("");

        for (int i = 0; i < chars.length; i++) {
            String str = chars[i];
            if(i != chars.length-1) { 
                str = isDesimal(chars[i], chars[i + 1]); // 두 자리 숫자 판별 및 반환
                if (!str.equals(chars[i]))
                    i++;
            }

            if(isNumber(str)){
                scores.push(Double.parseDouble(str));
            }else{                 // 숫자가 아닐 때
                if(str.equals("S")){
                    scores.push(scores.pop());
                }else if(str.equals("D")){
                    scores.push(Math.pow(scores.pop(),2));
                }else if(str.equals("T")){
                    scores.push(Math.pow(scores.pop(),3));
                }else if(str.equals("*")){
                    if(scores.size() > 1) {
                        double num2 = scores.pop();
                        double num1 = scores.pop();
                        scores.push(num1*2);
                        scores.push(num2*2);
                    }else{
                        double num = scores.pop();
                        scores.push(num*2);
                    }
                }else if(str.equals("#")){
                    double num = scores.pop();
                    scores.push(num * -1);
                }
            }
        }

        while(!scores.isEmpty()){
            answer += scores.pop();
        }
        return answer;
    }
}