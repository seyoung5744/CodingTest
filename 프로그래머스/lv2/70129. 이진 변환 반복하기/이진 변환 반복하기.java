class Solution {
    public int[] solution(String s) {
        int removed = 0;
        int loop = 0;
        
        while(!s.equals("1")){
            int zeros = countZero(s);
            loop+=1;
            removed += zeros;
            s = Integer.toString(s.length() - zeros, 2);            
        }
        return new int[]{loop, removed};
    }
    
    private int countZero(String s){
        int zeros = 0;
        for(char c : s.toCharArray()){
            if(c == '0') zeros++;
        }
        return zeros;
    }
}