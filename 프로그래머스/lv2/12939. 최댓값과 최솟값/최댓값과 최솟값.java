class Solution {
    public String solution(String s) {
        int min = Integer.parseInt(s.split(" ")[0]);
        int max = Integer.parseInt(s.split(" ")[0]);
        for (String ch : s.split(" ")){
            int num = Integer.parseInt(ch);
            if(min > num){
                min = num;
            }
            if(max < num){
                max = num;
            }
        }

        return min + " " +  max;
    }
}