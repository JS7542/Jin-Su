import java.util.*;

class Solution {
    /*
     * 모든 높이를 정렬하고 누적합을 만든다.
     * 각 기존 높이를 목표 높이로 가정해 낮은 블록을 채우는 비용과 높은 블록을 제거하는 비용을 계산한다.
     */
    public long solution(int[][] land, int P, int Q) {
        int size = land.length * land.length;
        long[] heights = new long[size];
        int index = 0;

        for (int[] row : land) {
            for (int height : row) heights[index++] = height;
        }

        Arrays.sort(heights);

        long[] prefix = new long[size + 1];

        for (int i = 0; i < size; i++) {
            prefix[i + 1] = prefix[i] + heights[i];
        }

        long answer = Long.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            long target = heights[i];
            long lowerBlocks = target * i - prefix[i];
            long upperBlocks = (prefix[size] - prefix[i + 1])
                    - target * (size - i - 1);

            long cost = lowerBlocks * P + upperBlocks * Q;
            answer = Math.min(answer, cost);
        }

        return answer;
    }
}
