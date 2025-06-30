import java.util.*;

class Solution {
    /*
     * 몸무게를 오름차순으로 처리하며 이전 몸무게 빈도를 저장한다.
     * 좌석 거리 비율 1:1, 2:3, 1:2, 3:4를 만족하는 더 작은 몸무게의 빈도를 더한다.
     */
    public long solution(int[] weights) {
        Arrays.sort(weights);

        Map<Integer, Long> count = new HashMap<>();
        long answer = 0;

        for (int weight : weights) {
            answer += count.getOrDefault(weight, 0L);

            if (weight * 2 % 3 == 0) {
                answer += count.getOrDefault(weight * 2 / 3, 0L);
            }

            if (weight % 2 == 0) {
                answer += count.getOrDefault(weight / 2, 0L);
            }

            if (weight * 3 % 4 == 0) {
                answer += count.getOrDefault(weight * 3 / 4, 0L);
            }

            count.put(weight, count.getOrDefault(weight, 0L) + 1);
        }

        return answer;
    }
}
