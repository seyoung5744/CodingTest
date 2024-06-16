import java.util.*;

public class Solution {

    static class Node {
        public Map<Character, Node> child = new HashMap<>();
        public int wordsCount;
        public boolean isEnd;
    }

    static class Trie {

        private Node rootNode = new Node();

        public void insert(String str) {
            Node node = this.rootNode;
            for (int i = 0; i < str.length(); i++) {
                if (!node.child.containsKey(str.charAt(i))) {
                    node.child.put(str.charAt(i), new Node());
                }
                node = node.child.get(str.charAt(i));
                node.wordsCount++;
            }
            node.isEnd = true;
        }

        public int getMinDepth(String str) {
            Node node = this.rootNode;

            for(int i = 0; i < str.length(); ++i) {
                node = node.child.get(str.charAt(i));

                if (node.wordsCount == 1)
                    return i + 1;
            }

            return str.length();
        }

    }

    public static int solution(String[] words) {
        int answer = 0;

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            answer += trie.getMinDepth(word);
        }

        return answer;
    }
}
