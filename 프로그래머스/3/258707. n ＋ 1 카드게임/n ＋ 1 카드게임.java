import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static Map<Integer, Integer> hands = new LinkedHashMap<>();
    public static int target;

    public static int solution(int coin, int[] cards) {
        int round = 1;
        target = cards.length + 1;

        for (int i = 0; i < cards.length / 3; i++) {
            hands.put(cards[i], 0);
        }

        for (int i = cards.length / 3; i < cards.length; i += 2, ++round) {
            hands.put(cards[i], 1);
            hands.put(cards[i + 1], 1);

            int num = -1;
            int needCoins = 0;
                
            for (int card : hands.keySet()) {
                if (hands.containsKey(target - card)) {
                    needCoins = hands.get(card) + hands.get(target - card);

                    if (needCoins <= coin) {
                        num = card;
                        break;
                    }
                }
            }
            
            if (num != -1)
            {
                hands.remove(num);
                hands.remove(target - num);
                coin -= needCoins;
            }
            else break;

        }

        return round;
    }

}
