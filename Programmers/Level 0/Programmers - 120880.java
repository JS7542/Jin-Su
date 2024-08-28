import java.util.*;

class Solution {
    /*
     * 기준값 n과의 거리가 가까운 순서로 정렬한다.
     * 거리가 같으면 더 큰 수가 먼저 오도록 비교 조건을 추가한다.
     */
    public int[] solution(int[] numlist, int n) {
        Integer[] values = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

        Arrays.sort(values, (a, b) -> {
            int distance = Integer.compare(Math.abs(a - n), Math.abs(b - n));
            return distance != 0 ? distance : Integer.compare(b, a);
        });

        return Arrays.stream(values).mapToInt(Integer::intValue).toArray();
    }
}
