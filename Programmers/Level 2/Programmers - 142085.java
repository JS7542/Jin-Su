import java.util.*;

class Solution {
    /*
     * 무적권을 사용할 라운드의 적 수를 최소 힙에 저장한다.
     * 힙 크기가 K를 넘으면 가장 적은 적 수 라운드를 병사로 막고 병사가 부족하면 종료한다.
     */
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> protectedRounds = new PriorityQueue<>();

        for (int round = 0; round < enemy.length; round++) {
            protectedRounds.offer(enemy[round]);

            if (protectedRounds.size() > k) {
                n -= protectedRounds.poll();
            }

            if (n < 0) return round;
        }

        return enemy.length;
    }
}
