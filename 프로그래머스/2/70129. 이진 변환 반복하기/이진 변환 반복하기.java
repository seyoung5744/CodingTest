class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zero = 0;
        while(!s.equals("1")) {
            String removed = s.replace("0", "");
            zero += s.length() - removed.length();
            
            s = Integer.toString(removed.length(), 2);
            count++;
        }
        return new int[] {count, zero};
    }
}