import java.util.*;

class Solution {
    /*
     * 최소 바위 간격을 정하면 그 간격을 만들기 위해 제거해야 하는 바위 수를 계산할 수 있다.
     * 제거 수가 n 이하인 가장 큰 최소 간격을 이분 탐색한다.
     */
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 1;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int removed = 0;
            int previous = 0;

            for (int rock : rocks) {
                if (rock - previous < middle) removed++;
                else previous = rock;
            }

            if (distance - previous < middle) removed++;

            if (removed <= n) {
                answer = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return answer;
    }
}
