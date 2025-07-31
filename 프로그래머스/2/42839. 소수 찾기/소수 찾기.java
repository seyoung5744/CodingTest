import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;

        Set<Integer> sample = new HashSet<>();
        for (int size = 1; size <= numbers.length(); size++) {
            generate("", size, sample, new boolean[numbers.length()], numbers);
        }

        for (int num : sample) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    private void generate(String temp, int size, Set<Integer> sample, boolean[] visited, String numbers) {
        if (temp.length() >= size) {
            sample.add(Integer.parseInt(temp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            generate(temp + numbers.charAt(i), size, sample, visited, numbers);
            visited[i] = false;
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}