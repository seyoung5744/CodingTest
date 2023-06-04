import java.util.*;

class Member implements Comparable<Member>{
    int age;
    String name;
    int priority;

    public Member(int age, String name, int priority) {
        this.age = age;
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Member o) {
        if(this.age == o.age){
            return Integer.compare(this.priority, o.priority);
        }

        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
public class Main {

    public static Member[] members;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        members = new Member[n];
        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members[i] = new Member(age, name, i);
        }

        Arrays.sort(members);

        for (int i = 0; i < n; i++) {
            System.out.println(members[i]);
        }
    }

}
