class Solution {
    public String solution(String s) {
        String[] strNum = s.split(" ");
        int min = Integer.parseInt(strNum[0]);
        int max = Integer.parseInt(strNum[0]);
        for (String ch : strNum){
            int num = Integer.parseInt(ch);
            if(min > num) min = num;
            if(max < num) max = num;
        }

        return min + " " +  max;
    }
}