import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static final double[] DISCOUNT_RATIO = {0.1, 0.2, 0.3, 0.4};
    public static List<List<Double>> emoticonRatiosResult = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        setEmoticonPriceByDiscount(emoticons, new ArrayList<>(), 0);
        return calculateUser(users, emoticons);
    }

    private static int[] calculateUser(int[][] users, int[] emoticons) {
        int maxPlusUser = Integer.MIN_VALUE;
        int maxPrice = Integer.MIN_VALUE;

        for (List<Double> ratios : emoticonRatiosResult) {

            int plusUser = 0;
            int price = 0;
            for (int[] user : users) {
                double wantUserRatio = user[0] / 100.0;
                int totalPay = 0;
                boolean flag = false;
                for (int i = 0; i < emoticons.length; i++) {
                    if (ratios.get(i) >= wantUserRatio) {
                        totalPay += emoticons[i] * (1 - ratios.get(i));
                    }

                    if (totalPay >= user[1]) { // 플러스 가입
                        flag = true;
                        break;
                    }
                }

                if (flag == true) {
                    plusUser++;
                } else {
                    price += totalPay;
                }
            }

            if (plusUser > maxPlusUser) {
                maxPlusUser = plusUser;
                maxPrice = price;
            } else if (plusUser == maxPlusUser && price > maxPrice) {
                maxPrice = price;
            }
        }
        return new int[]{maxPlusUser, maxPrice};
    }

    private static void setEmoticonPriceByDiscount(int[] emoticons, List<Double> emoticonRatios, int depth) {
        if (depth >= emoticons.length) {
            emoticonRatiosResult.add(new ArrayList<>(emoticonRatios));
            return;
        }

        for (int i = 0; i < DISCOUNT_RATIO.length; i++) {
            emoticonRatios.add(DISCOUNT_RATIO[i]);
            setEmoticonPriceByDiscount(emoticons, emoticonRatios, depth + 1);
            emoticonRatios.remove(emoticonRatios.size() - 1);
        }
    }
}
