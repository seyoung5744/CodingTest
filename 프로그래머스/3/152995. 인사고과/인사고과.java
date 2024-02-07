import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import java.util.*;
import java.util.stream.*;

public class Solution {

    static class Person {

        int num;
        int attitude;
        int partner;
        int sum;

        Person(int num, int atti, int part) {
            this.num = num;
            this.attitude = atti;
            this.partner = part;
            this.sum = atti + part;
        }

        public int getNum() {
            return num;
        }

        public int getAttitude() {
            return attitude;
        }

        public int getPartner() {
            return partner;
        }

        public int getSum() {
            return sum;
        }

    }

    private static List<Person> people = new ArrayList<>();
    private static List<Person> rank = new ArrayList<>();

    public static int solution(int[][] scores) {
        int answer = -1;

        for (int i = 0; i < scores.length; i++) {
            people.add(new Person(i, scores[i][0], scores[i][1]));
        }

        people = people.stream()
            .sorted(comparing(Person::getAttitude, Comparator.reverseOrder())
                .thenComparing(Person::getPartner, Comparator.reverseOrder()))
            .collect(Collectors.toList());

        rank.add(people.get(0));
        Person temp = people.get(0);
        Person max = new Person(0, 0, 0);
        for (int i = 1; i < people.size(); i++) {
            Person cur = people.get(i);

            if (cur.getAttitude() == people.get(i - 1).getAttitude()) {
                if (cur.getPartner() >= max.getPartner()) {
                    rank.add(cur);
                }
            } else {
                if(temp.getPartner() > max.getPartner())
                {
                    max = temp;
                }
                if (temp.getPartner() < cur.getPartner())
                {
                    temp = cur;
                }

                if (cur.getPartner() >= max.getPartner()) {
                    rank.add(cur);
                }
            }
        }

        rank = rank.stream()
            .sorted(comparing(Person::getSum, reverseOrder())
                .thenComparing(Person::getNum))
            .collect(Collectors.toList());


        for (int i = 0; i < rank.size(); i++) {
            if (rank.get(i).getNum() == 0) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

}
