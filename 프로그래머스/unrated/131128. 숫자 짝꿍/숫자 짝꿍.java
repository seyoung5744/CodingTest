import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
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

        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] >= 1 && arr2[i] >= 1){
                if(arr1[i] <= arr2[i])
                    sb.append(String.valueOf(i).repeat(Math.max(0, arr1[i])));
                else if(arr1[i] >= arr2[i])
                    sb.append(String.valueOf(i).repeat(Math.max(0, arr2[i])));
            }
        }

        StringBuilder sb2 = new StringBuilder();
        
        if(sb.length() != 0){
            char[] chars = sb.toString().toCharArray();
            Arrays.sort(chars);

            for (int i = chars.length-1; i >=0 ; i--) {
                sb2.append(chars[i]);
            }
        }

        if(sb2.length() == 0){
            return "-1";
        } else if (sb2.charAt(0) == '0') {
            return "0";
        }

        return sb2.toString();
    }
}