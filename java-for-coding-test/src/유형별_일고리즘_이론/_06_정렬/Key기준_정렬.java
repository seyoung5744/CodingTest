package 유형별_일고리즘_이론._06_정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Fruit implements Comparable<Fruit> {

    private String name;
    private int score;

    public Fruit(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Fruit o) {
        return this.score < o.score? -1 : 1;
    }

    @Override
    public String toString() {
        return "Fruit{" +
            "name='" + name + '\'' +
            ", score=" + score +
            '}';
    }
}

public class Key기준_정렬 {
    public static void main(String[] args){
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        fruits.forEach(fruit -> System.out.println(fruit.toString()));
    }
}
