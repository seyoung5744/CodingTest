import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for (int i = 0; i < X.length() ; i++) {
            int idx = Character.getNumericValue(X.charAt(i));
            arr1[idx] += 1;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int idx = Character.getNumericValue(Y.charAt(i));
            arr2[idx]+=1;
        }
        
        StringBuilder sb = new StringBuilder();

        for (int i = arr1.length-1; i >= 0 ; i--) {
            if(arr1[i] >= 1 && arr2[i] >= 1){
                if(arr1[i] <= arr2[i])
                    sb.append(String.valueOf(i).repeat(arr1[i]));
                else
                    sb.append(String.valueOf(i).repeat(arr2[i]));
            }
        }

        if(sb.length() == 0){
            return "-1";
        } else if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}