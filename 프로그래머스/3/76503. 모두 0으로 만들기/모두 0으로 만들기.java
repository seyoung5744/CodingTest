import java.util.*;

public class Solution {

    public static class Node {

        int idx;
        Set<Integer> linkedNode;

        public Node(int idx) {
            this.idx = idx;
            this.linkedNode = new HashSet<>();
        }
    }

    public static List<Node> graph = new ArrayList<>();

    public static long solution(int[] ab, int[][] edges) {
        long answer = 0;

        long[] a = new long[ab.length];
        for (int i = 0; i < ab.length; i++) {
            a[i] = ab[i];
            graph.add(new Node(i));
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.get(x).linkedNode.add(y);
            graph.get(y).linkedNode.add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).linkedNode.size() == 1) {
                q.offer(i);
            }
        }

        int nodeCount = 0;
        int lastIdx = 0;
        while (!q.isEmpty()) {
            int curIdx = q.poll();
            nodeCount++;
            lastIdx = curIdx;

            if (graph.get(curIdx).linkedNode.size() == 0) {
                continue;
            }

            int next = graph.get(curIdx).linkedNode.iterator().next();

            answer += Math.abs(a[curIdx]);
            a[next] += a[curIdx];
            a[curIdx] = 0;

            graph.get(next).linkedNode.remove(curIdx);

            if (graph.get(next).linkedNode.size() == 1) {
                q.offer(next);
            }
        }

        if (a[lastIdx] != 0) {
            return -1;
        }

        return answer;
    }
}