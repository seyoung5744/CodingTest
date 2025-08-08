import java.util.*;

class Solution {
     public int solution(int[] cards) {
        boolean[] opened = new boolean[cards.length];

        List<Integer> cardSetSizeList = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (opened[i]) continue;

            int size = inOrderOpen(i, cards, opened);
            cardSetSizeList.add(size);
        }

        Collections.sort(cardSetSizeList);
        int size = cardSetSizeList.size();
        if (size < 2) {
            return 0;
        }
        return cardSetSizeList.get(size - 1) * cardSetSizeList.get(size - 2);
    }

    private int inOrderOpen(int num, int[] cards, boolean[] opened) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(num);
        opened[num] = true;

        int size = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int next = cards[cur] - 1;
            if (opened[next]) continue;

            opened[next] = true;
            q.offer(next);
            size++;
        }

        return size;
    }
}