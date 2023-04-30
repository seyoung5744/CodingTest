package _14_정렬._23_국영수;

import java.util.*;

/*
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 89 79 199
Soong 50 60 90
Haebin 50 60 100
kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90

 */
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

    /*
    [ 정렬 기준 ]
    1) 두 번째 원소를 기준으로 내림차순 정렬
    2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
    3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
    4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬
    */

    // 정렬 기준은 '점수가 낮은 순서'
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
