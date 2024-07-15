import java.util.*;

class Solution {
    /*
     * 신청 금액을 오름차순으로 정렬해 적은 금액부터 지원한다.
     * 예산을 넘기기 전까지 지원한 부서 수를 센다.
     */
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        for (int amount : d) {
            if (budget < amount) break;
            budget -= amount;
            answer++;
        }

        return answer;
    }
}
