import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> hand = new ArrayList<>(); // 갖고 있는 숫자들
    public static boolean[] isInHand;
    public static boolean[] isRequestCoin;
    public static int target;

    public static int solution(int coin, int[] cards) {
        int round = 1;
        target = cards.length + 1;
        isInHand = new boolean[target];
        isRequestCoin = new boolean[target];

        for (int i = 0; i < cards.length / 3; i++) {
            hand.add(cards[i]);
            isInHand[cards[i]] = true;
        }

        for (int i = cards.length / 3; i < cards.length; i += 2, ++round) {
            System.out.println(cards[i] + "," + cards[i + 1]);

            hand.add(cards[i]);
            hand.add(cards[i + 1]);
            isInHand[cards[i]] = true;
            isInHand[cards[i + 1]] = true;
            isRequestCoin[cards[i]] = true;
            isRequestCoin[cards[i + 1]] = true;

            boolean flag = false;

            for (int card : hand) {
                if (isInHand[target - card]) {
                    int needCoins = 0;

                    if (isRequestCoin[target - card]) {
                        needCoins++;
                    }
                    if (isRequestCoin[card]) {
                        needCoins++;
                    }

                    if (needCoins <= coin) {
                        isInHand[card] = false;
                        isInHand[target - card] = false;
                        hand.remove(Integer.valueOf(card));
                        hand.remove(Integer.valueOf(target - card));
                        coin -= needCoins;
                        flag = true;
                        break;
                    }
                }
            }

            if (!flag) {
                break;
            }

        }

        return round;
    }
}
