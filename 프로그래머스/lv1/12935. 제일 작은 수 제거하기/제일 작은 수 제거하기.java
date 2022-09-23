import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length-1 == 0){
            return new int[]{-1};
        }

        int[] answer = new int[arr.length-1];
        int min = arr[0];

        for(int a : arr){
            if(a < min){
                min = a;
            }
        }

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != min){
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}