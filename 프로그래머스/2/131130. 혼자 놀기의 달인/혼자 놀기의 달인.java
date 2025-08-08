import java.util.*;

class Solution {
     public int solution(int[] cards) {
        boolean[] opened = new boolean[cards.length];

        List<List<Integer>> cardSet = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (opened[i]) continue;

            List<Integer> openedBoxes = inOrderOpen(i, cards, opened);
            cardSet.add(openedBoxes);
        }

        Collections.sort(cardSet, (a, b) -> Integer.compare(a.size(), b.size()));
        int size = cardSet.size();
        if (size < 2) {
            return 0;
        }
        return cardSet.get(size - 1).size() * cardSet.get(size - 2).size();
    }

    private List<Integer> inOrderOpen(int num, int[] cards, boolean[] opened) {
        List<Integer> openedBox = new ArrayList<>();
        openedBox.add(num);

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(num);
        opened[num] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int next = cards[cur] - 1;
            if (opened[next]) continue;

            opened[next] = true;
            q.offer(next);
            openedBox.add(next);
        }

        return openedBox;
    }
}