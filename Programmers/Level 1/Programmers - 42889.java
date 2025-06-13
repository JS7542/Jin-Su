import java.util.*;

class Solution {
    /*
     * 스테이지별 멈춰 있는 사용자 수를 센다.
     * 해당 스테이지 도달 인원으로 나눈 실패율을 계산하고 실패율·번호 순으로 정렬한다.
     */
    public int[] solution(int N, int[] stages) {
        int[] stopped = new int[N + 2];

        for (int stage : stages) stopped[stage]++;

        List<Integer> order = new ArrayList<>();
        double[] failure = new double[N + 1];
        int reached = stages.length;

        for (int stage = 1; stage <= N; stage++) {
            failure[stage] = reached == 0 ? 0.0 : (double) stopped[stage] / reached;
            reached -= stopped[stage];
            order.add(stage);
        }

        order.sort((first, second) -> {
            int compare = Double.compare(failure[second], failure[first]);
            return compare != 0 ? compare : Integer.compare(first, second);
        });

        return order.stream().mapToInt(Integer::intValue).toArray();
    }
}
