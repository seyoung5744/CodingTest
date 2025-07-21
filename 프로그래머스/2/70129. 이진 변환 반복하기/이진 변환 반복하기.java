class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zero = 0;
        
        while(!"1".equals(s)) {
            String removed = s.replace("0", "");
            zero += s.length() - removed.length();
            
            count++;
            s = Integer.toString(removed.length(), 2);
        }
        return new int[]{count, zero};
    }
}