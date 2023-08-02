class Solution {

    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;

        while(!s.equals("1")){
            int zeros = countZero(s);
            removed += zeros;
            loop += 1;
            s = Integer.toString(s.length() - zeros, 2);
        }
        
        return new int[]{loop, removed};
    }

    private static int countZero(String s){
        int zero = 0;
        for(char c : s.toCharArray()){
            if(c == '0') zero++;
        }
        return zero;
    }
}
