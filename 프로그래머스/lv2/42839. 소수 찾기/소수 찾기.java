import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        String[] nums = numbers.split("");
        boolean[] visited = new boolean[numbers.length()];

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            String[] out = new String[i];
            permutation(nums, 0, i, visited, out, set);
        }
        

        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int num = it.next();
            boolean flag = false;
            if(num > 1) {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if(num % i == 0){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    answer+=1;
                }
            }

        }
        return answer;
    }
    static String result = "";
    public static void permutation(String[] arr, int depth, int r, boolean[] visited, String[] out, Set<Integer> set) {
        if(depth == r){
            Arrays.stream(out).forEach(x -> result+=x);
            set.add(Integer.parseInt(result));
            result = "";
            return;

        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth+1 , r, visited, out, set);
                visited[i] = false;
            }
        }
    }
}