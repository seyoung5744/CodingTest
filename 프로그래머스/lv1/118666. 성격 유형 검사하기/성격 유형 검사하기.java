import java.util.HashMap;
class Solution {
      HashMap<Character,Integer> personality = new HashMap<>() {{
        put('R',0);
        put('T',0);
        put('C',0);
        put('F',0);
        put('J',0);
        put('M',0);
        put('A',0);
        put('N',0);
    }};

    public char compare(char c1, char c2){
        char person;
        if(this.personality.get(c1) > this.personality.get(c2)){
            person =  c1;
        }else if (this.personality.get(c2) > this.personality.get(c1)){
            person =  c2;
        }else{
            person =  c1 < c2? c1:c2;
        }
        return person;
    }
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);

            if(choices[i] < 4){
                this.personality.put(disagree, this.personality.get(disagree)+Math.abs(choices[i]-4));
            }else if(choices[i] > 4){
                this.personality.put(agree, this.personality.get(agree)+Math.abs(choices[i]-4));
            }
        }

        answer+= compare('T','R');
        answer+= compare('C','F');
        answer+= compare('J','M');
        answer+= compare('A','N');
        return answer;
    }
}