import java.util.*;

class Student implements Comparable<Student>{
    private String name;
    private int ko;
    private int en;
    private int math;

    public Student(String name, int ko, int en, int math){
        this.name = name;
        this.ko = ko;
        this.en = en;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        if(this.ko==other.ko && this.en==other.en && this.math==other.math){
            return this.name.compareTo(other.name);
        }
        if(this.ko==other.ko && this.en==other.en){
            return Integer.compare(other.math, this.math);
        }

        if(this.ko==other.ko){
            return Integer.compare(this.en, other.en);
        }

        return Integer.compare(other.ko, this.ko);
    }
}
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int ko = sc.nextInt();
            int en = sc.nextInt();
            int math = sc.nextInt();
            students.add(new Student(name, ko, en, math));
        }

        Collections.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
    }
}
