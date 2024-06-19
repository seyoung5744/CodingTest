import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static class Person {

        String name;
        int money;
        Person parent;

        public Person(String name) {
            this.name = name;
        }

        void getReward(int i) {
            int moneyToParent = (int) (i * 0.1);
            this.money += i - moneyToParent;
            if (this.parent != null)
                this.parent.getReward(moneyToParent);
        }
    }

    public static Map<String, Person> person = new HashMap<>();

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        for (int i = 0; i < enroll.length; i++) {
            person.put(enroll[i], new Person(enroll[i]));
        }
        person.put("-", new Person("-"));

        for (int i = 0; i < referral.length; i++) {
            person.get(enroll[i]).parent = person.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            String sell = seller[i];

            int money = amount[i] * 100;
            person.get(seller[i]).getReward(amount[i] * 100);
//            while (person.get(sell).parent != null) {
//                Person cur = person.get(sell);
//
//                int up = (int) (money * 0.1);
//                if (up < 1) {
//                    up = 0;
//                }
//                cur.money += money - up;
//                money = up;
//                sell = cur.parent.name;
//            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = person.get(enroll[i]).money;
        }

        return answer;
    }

}
