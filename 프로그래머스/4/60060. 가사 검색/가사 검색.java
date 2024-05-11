import java.util.*;

class Solution {
     public static int lowerRound(ArrayList<String> arr, String target, int start, int end) {
        while(start < end){
            int mid = (start + end) / 2;
            if(arr.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int upperRound(ArrayList<String> arr, String target, int start, int end) {
        while(start<end){
            int mid = (start + end) / 2;
            // arr[mid]가 target보다 사전순으로 뒤에 있다면
            if(arr.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
        int leftIndex = lowerRound(arr, leftValue, 0, arr.size());
        int rightIndex = upperRound(arr, rightValue, 0, arr.size());
        return rightIndex - leftIndex;
    }

    public static ArrayList<ArrayList<String>> arr = new ArrayList<>();
    public static ArrayList<ArrayList<String>> reversedArr = new ArrayList<>();
    public int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<>());
            reversedArr.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            arr.get(word.length()).add(word);
            word = (new StringBuilder(word)).reverse().toString();
            reversedArr.get(word.length()).add(word);
        }

        for (int i = 0; i < 10001; i++) {
            Collections.sort(arr.get(i));
            Collections.sort(reversedArr.get(i));
        }

        for (int i = 0; i < queries.length; i++) {
            String word = queries[i];

            int res = 0;
            if (word.charAt(0) != '?') {
                res = countByRange(arr.get(word.length()), word.replaceAll("\\?","a"), word.replaceAll("\\?","z"));
            } else {
                word = (new StringBuilder(word)).reverse().toString();
                res = countByRange(reversedArr.get(word.length()), word.replaceAll("\\?","a"), word.replaceAll("\\?","z"));
            }
            result.add(res);
        }

     
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}