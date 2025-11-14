import java.util.*;

class Solution {
    /*
     * 콜라츠 수열의 각 구간 넓이를 사다리꼴 공식으로 계산해 누적합을 만든다.
     * 요청 구간의 시작과 끝 인덱스를 변환해 누적합 차이로 넓이를 반환한다.
     */
    public double[] solution(int k, int[][] ranges) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(k);

        while (k != 1) {
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;

            sequence.add(k);
        }

        double[] prefix = new double[sequence.size()];

        for (int index = 1; index < sequence.size(); index++) {
            prefix[index] = prefix[index - 1]
                    + (sequence.get(index - 1) + sequence.get(index)) / 2.0;
        }

        double[] answer = new double[ranges.length];
        int last = sequence.size() - 1;

        for (int index = 0; index < ranges.length; index++) {
            int start = ranges[index][0];
            int end = last + ranges[index][1];

            answer[index] = start > end
                    ? -1.0
                    : prefix[end] - prefix[start];
        }

        return answer;
    }
}
