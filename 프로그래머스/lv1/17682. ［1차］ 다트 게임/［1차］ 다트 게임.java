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
        ArrayList<Double> scores = new ArrayList<>();
        int idx = 0;
        String[] chars = dartResult.split("");

        for (int i = 0; i < chars.length; i++) {
            String str = chars[i];
            if(i != chars.length-1) {
                str = isDesimal(chars[i], chars[i + 1]);
                if (!str.equals(chars[i]))
                    i++;
            }

            if(isNumber(str)){
                scores.add(Double.parseDouble(str));
                ++idx;
            }else{                 // 숫자가 아닐 때
                if(str.equals("S")){
                    scores.add(scores.remove(--idx));
                }else if(str.equals("D")){
                    scores.add(Math.pow(scores.remove(--idx),2));
                }else if(str.equals("T")){
                    scores.add(Math.pow(scores.remove(--idx),3));
                }else if(str.equals("*")){
                    if(scores.size() > 1) {
                        double num2 = scores.remove(--idx);
                        double num1 = scores.remove(--idx);
                        scores.add(num1*2);
                        idx++;
                        scores.add(num2*2);
                    }else{
                        double num = scores.remove(--idx);
                        scores.add(num*2);
                    }
                }else if(str.equals("#")){
                    double num = scores.remove(--idx);
                    scores.add(num * -1);
                }
                idx++;
            }
        }
        
        for(double score: scores){
            answer += (int)score;
        }
        return answer;
    }
}