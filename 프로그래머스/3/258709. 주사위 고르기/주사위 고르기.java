import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution{

    public static int pickNum, totalLen;
    public static List<int[]> diceCombA = new ArrayList<>();
    public static List<int[]> diceCombB = new ArrayList<>();
    public static Map<Integer, Integer> a = new TreeMap<>();
    public static Map<Integer, Integer> b = new TreeMap<>();

    public static int[] solution(int[][] dice) {
        int max = 0;
        totalLen = dice.length;
        pickNum = dice.length / 2;

        int[] answer = new int[pickNum];

        combination(0, 0, new int[pickNum]);

        for (int i = 0; i < diceCombA.size(); i++) {
            cal(dice, i, 0, 0, 0);

            int winCount = 0;
            int drawCount = 0;

            for(int numA : a.keySet())
            {
                for(int numB : b.keySet())
                {
                    if (numA > numB)
                    {
                        winCount += a.get(numA) * b.get(numB);
                    }
                    else if (numA == numB)
                    {
                        drawCount += a.get(numA) * b.get(numB);
                    }
                    else {
                        break;
                    }
                }
            }


            int total = (int)Math.pow(6, pickNum) * (int)Math.pow(6, pickNum);
            int loseCount = total - winCount - drawCount;

            if (winCount >= loseCount)
            {
                if (max < winCount)
                {
                    max = winCount;
                    answer = diceCombA.get(i);
                }
            }
            else
            {
                if (max < loseCount)
                {
                    max = loseCount;
                    answer = diceCombB.get(diceCombB.size() - i - 1);
                }
            }

            a = new TreeMap<>();
            b = new TreeMap<>();
        }
        return answer;
    }

    public static void cal(int[][] dice, int combNum, int diceIdx, int sumA, int sumB) {
        if (diceIdx >= diceCombA.get(0).length) {
            a.put(sumA, a.getOrDefault(sumA, 0) + 1);
            b.put(sumB, b.getOrDefault(sumB, 0) + 1);
            return;
        }

        for(int i = 0; i < 6; ++i)
        {
            int[] intsA = diceCombA.get(combNum);
            int a = intsA[diceIdx] - 1;

            int[] intsB = diceCombB.get(diceCombB.size() - combNum - 1);
            int b = intsB[diceIdx] - 1;

            cal (dice, combNum, diceIdx + 1, sumA + dice[a][i], sumB + dice[b][i]);
        }
    }

    public static void combination(int start, int index, int[] out) {
        if (index == pickNum) {
            if (out[0] == 1) {
                diceCombA.add(out);
            } else {
                diceCombB.add(out);
            }
            return;
        }

        for (int i = start; i < totalLen; i++) {
            out[index] = i + 1;
            combination(i + 1, index + 1, Arrays.copyOf(out, out.length));
        }
    }

}
