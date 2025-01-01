import java.util.*;

class Solution {
    /*
     * 사탕 가격을 오름차순으로 정렬하고 비싼 사탕부터 세 개씩 묶는다.
     * 각 세 번째 사탕은 무료이므로 두 개 가격만 합산한다.
     */
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int answer = 0;
        int bought = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            if (bought % 3 != 2) answer += cost[i];
            bought++;
        }

        return answer;
    }
}
