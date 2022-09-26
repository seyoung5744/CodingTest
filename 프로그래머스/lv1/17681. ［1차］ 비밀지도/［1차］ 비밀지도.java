class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            long binaryInt = Long.parseLong(Long.toBinaryString(arr1[i] | arr2[i]));
            String str = String.format("%0" + n + "d",binaryInt );
            str = str.replace('1','#').replace('0',' ');
            answer[i] = str;
        }

        return answer;
    }
}