package _12_구현._09_문자열압축;

import java.util.*;

/*
aabbaccc

ababcdcdababcdcd

abcabcdede

abcabcabcabcdededededede

xababcdcdababcdcd
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int answer = s.length();

        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String pre = s.substring(0, step);
            int cnt = 1;

            // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
            for (int i = step; i < s.length(); i += step) {
                String sub = "";
                // 이전 상태와 동일하다면 압축 횟수(count) 증가
                for (int j = i; j < i + step; j++) {
                    if(j < s.length()) sub += s.charAt(j);
                }

                if(pre.equals(sub)) cnt += 1;
                // 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
                else{
                    compressed += (cnt >= 2)? cnt + pre : pre;

                    pre = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }

            System.out.println("마지막 전 : " + compressed);
            // 남아있는 문자열에 대해서 처리
            compressed += (cnt >= 2)? cnt + pre : pre;
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
            System.out.println("앞축 : " + compressed);
        }

        System.out.println(answer);
    }

}
