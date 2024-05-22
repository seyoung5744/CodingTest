
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static class Node {

        Map<Character, Node> childes = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
    }

    static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        void insert(Node curNode, String word, int depth) {

            int remain = word.length() - depth;

            curNode.count.put(remain, curNode.count.getOrDefault(remain, 0) + 1);

            if (remain == 0) {
                return;
            }
            char initial = word.charAt(depth);

            if (!curNode.childes.containsKey(initial)) {
                Node newNode = new Node();
                curNode.childes.put(initial, newNode);
            }

            insert(curNode.childes.get(initial), word, depth + 1);
        }

        int search(Node curNode, String word, int depth) {

            int remain = word.length() - depth;

            if (!curNode.count.containsKey(remain)) {
                return 0;
            }

            if (remain == 0) {
                return curNode.count.get(remain);
            }

            int sum = 0;
            char initial = word.charAt(depth);

            if (initial == '?') { // 반복
                return curNode.count.getOrDefault(remain, 0);
            }

            if (curNode.childes.containsKey(initial)) { // 거기 타고
                sum += search(curNode.childes.get(initial), word, depth + 1);
            }

            return sum;
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Trie trie = new Trie();
        Trie reverse = new Trie();

        for (String word : words) {
            trie.insert(trie.root, word, 0);
            reverse.insert(reverse.root, new StringBuilder(word).reverse().toString(), 0);
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i].startsWith("?")) {
                answer[i] = reverse.search(reverse.root, new StringBuilder(queries[i]).reverse().toString(), 0);
            } else {
                answer[i] = trie.search(trie.root, queries[i], 0);
            }
        }

        return answer;
    }

}
