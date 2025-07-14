import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {       
        boolean[] exists = new boolean[10];
        int[] nums = new int[10];
        for (int i = 0; i < X.length(); i++) {
            exists[X.charAt(i) - '0'] = true;
            nums[X.charAt(i) - '0']++;
        }

        String str = "";
        int[] count = new int[10];
        for (int i = 0; i < Y.length(); i++) {
            if (exists[Y.charAt(i) - '0'] && nums[Y.charAt(i) - '0'] > 0) {
                nums[Y.charAt(i) - '0']--;
                count[Y.charAt(i) - '0']++;
            }
        }
    
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        
        if (sb.toString().isEmpty()) return "-1";
        if (sb.toString().charAt(0) == '0') return "0";
        
        return sb.toString();
    }
}