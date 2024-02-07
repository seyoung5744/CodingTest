import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    static class Person {

        String name;
        String parent;
        int amount;

        public Person(String name, String parent) {
            this.name = name;
            this.parent = parent;
            this.amount = 0;
        }

        public int getAmount() {
            return amount;
        }

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        amount = Arrays.stream(amount).map(i -> i * 100).toArray();
        Map<String, Person> personMap = new LinkedHashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            personMap.put(enroll[i], new Person(enroll[i], referral[i]));
        }
        for (int i = 0; i < seller.length; i++) {
            Person current = personMap.get(seller[i]);

            int total = amount[i];

            while (current != null && total != 0) {
                int parentProfit = (int) (total * 0.1);

                current.amount += (total - parentProfit);
                total = parentProfit;
                current = personMap.get(current.parent);
            }
        }

        return personMap.values().stream()
            .mapToInt(Person::getAmount)
            .toArray();
    }

}
