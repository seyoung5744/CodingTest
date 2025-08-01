package 프로그래머스.정렬._05_heap_sort;

import java.util.Arrays;
import java.util.PriorityQueue;

class HeapSort {

    public static void sort(int[] arr) {
        heapsort(arr, arr.length);
    }

    public static void heapsort(int[] arr, int size) {
        /*
         * 부모노드와 heaify과정에서 음수가 발생하면 잘못 된 참조가 발생하기 때문에
         * 원소가 1개이거나 0개일 경우는 정렬 할 필요가 없으므로 바로 함수를 종료한다.
         */
        if (size < 2) {
            return;
        }

        // 가장 마지막 노드의 부모 노드 인덱스
        int parentIdx = getParent(size - 1);

        // max heap 만들기
        for (int i = parentIdx; i >= 0; i--) {

            // 부모노드(i값)을 1씩 줄이면서 heap 조건을 만족시키도록 재구성한다.
            heapify(arr, i, size - 1);
        }

        // 정렬 과정
        for (int i = size - 1; i > 0; i--) {
            /*
             *  root인 0번째 인덱스와 i번째 인덱스의 값을 교환해준 뒤
             *  0 ~ (i-1) 까지의 부분트리에 대해 max heap을 만족하도록
             *  재구성한다.
             */
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }

    }

    // 부모 인덱스를 얻는 함수
    private static int getParent(int child) {
        return child / 2;
    }

    // 두 인덱스의 원소를 교환하는 함수
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 힙을 만드는 함수 - 재귀
    private static void heapify(int[] a, int parentIdx, int lastIdx) {

        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        /*
         * 현재 부모 인덱스의 자식 노드 인덱스가
         * 마지막 인덱스를 넘지 않을 때 까지 반복한다.
         *
         * 이 때 왼쪽 자식 노드를 기준으로 해야 한다.
         * 오른쪽 자식 노드를 기준으로 범위를 검사하게 되면
         * 마지막 부모 인덱스가 왼쪽 자식만 갖고 있을 경우
         * 왼쪽 자식노드와는 비교 및 교환을 할 수 없기 때문이다.
         */

        while ((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;

            /*
             * left child node와 비교
             * (범위는 while문에서 검사했으므로 별도 검사 필요 없음)
             */
            if (a[largestIdx] < a[leftChildIdx]) {
                largestIdx = leftChildIdx;
            }

            /*
             * right child node와 비교
             * right child node는 범위를 검사해주어야한다.
             */
            if (rightChildIdx <= lastIdx && a[largestIdx] < a[rightChildIdx]) {
                largestIdx = rightChildIdx;
            }

            /*
             * 교환이 발생했을 경우 두 원소를 교체 한 후
             * 교환이 된 자식노드를 부모 노드가 되도록 교체한다.
             */
            if (parentIdx != largestIdx) {
                swap(a, parentIdx, largestIdx);
                parentIdx = largestIdx;
            } else {
                return;
            }
        }
    }

    // 힙을 만드는 함수 - 재귀
    private static void heapifyRecursive(int[] a, int parentIdx, int lastIdx) {

        /*
         * 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
         * 현재 부모 인덱스를 가장 큰 값을 갖고있다고 가정한다.
         */
        int leftChildIdx = parentIdx * 2 + 1;
        int rightChildIdx = parentIdx * 2 + 2;
        int largestIdx = parentIdx;

        /*
         *  left child node와 비교
         *
         *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
         *  현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클경우
         *  가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드인덱스로 바꿔준다.
         *
         */
        if (leftChildIdx <= lastIdx && a[largestIdx] < a[leftChildIdx]) {
            largestIdx = leftChildIdx;
        }

        /*
         *  left right node와 비교
         *
         *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
         *  현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
         *  가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드인덱스로 바꿔준다.
         *
         */
        if (rightChildIdx <= lastIdx && a[largestIdx] < a[rightChildIdx]) {
            largestIdx = rightChildIdx;
        }

        /*
         * largestIdx 와 부모노드가 같지 않다는 것은
         * 위 자식노드 비교 과정에서 현재 부모노드보다 큰 노드가 존재한다는 뜻이다.
         * 그럴 경우 해당 자식 노드와 부모노드를 교환해주고,
         * 교환 된 자식노드를 부모노드로 삼은 서브트리를 검사하도록 재귀 호출 한다.
         */
        if (parentIdx != largestIdx) {
            swap(a, parentIdx, largestIdx);
            heapifyRecursive(a, largestIdx, lastIdx);
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 4, 2, 8};
        test1(arr);
        test2(arr);
    }

    private static void test2(int[] arr) {
        System.out.println();
        HeapSort.sort(arr);
        System.out.println("재정렬 : " + Arrays.toString(arr));
    }
    private static void test1(int[] arr) {
        System.out.print("정렬 전 original 배열 : ");
        for (int val : arr) {
            System.out.print(val + " ");
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 배열을 힙으로 만든다.
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        // 힙에서 우선순위가 가장 높은 원소(root노드) 를 하나씩 뽑는다.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }

        System.out.print("\n 정렬 후, 배열 : ");
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
