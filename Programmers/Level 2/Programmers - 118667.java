import java.util.*;

class Solution {
    /*
     * 두 큐의 합을 계산하고 합이 큰 큐의 앞 원소를 다른 큐로 이동한다.
     * 전체 원소 이동 횟수에 상한을 두고 두 합이 같아지는 최소 횟수를 구한다.
     */
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> first = new ArrayDeque<>();
        Queue<Long> second = new ArrayDeque<>();

        long firstSum = 0;
        long secondSum = 0;

        for (int value : queue1) {
            first.offer((long) value);
            firstSum += value;
        }

        for (int value : queue2) {
            second.offer((long) value);
            secondSum += value;
        }

        int limit = (queue1.length + queue2.length) * 3;

        for (int operation = 0; operation <= limit; operation++) {
            if (firstSum == secondSum) return operation;

            if (firstSum > secondSum) {
                if (first.isEmpty()) break;

                long value = first.poll();
                firstSum -= value;
                secondSum += value;
                second.offer(value);
            } else {
                if (second.isEmpty()) break;

                long value = second.poll();
                secondSum -= value;
                firstSum += value;
                first.offer(value);
            }
        }

        return -1;
    }
}
