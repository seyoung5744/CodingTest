class Solution {
    public static int[] solution(String s) {
        int zero = 0;
        int count = 0;

        while(!s.equals("1")) {
            int removed = countZero(s);
            zero += removed;
            s = convert(s.length() - removed);
            count++;
        }
        return new int[]{count, zero};
    }

    public static int countZero(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') {
                count++;
            }
        }
        return count;
    }

    public static String convert(int num) {
        return Integer.toString(num, 2);
    }
}