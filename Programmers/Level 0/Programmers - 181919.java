import java.util.*;

class Solution {
    /*
     * 현재 값이 짝수이면 2로 나누고 홀수이면 3을 곱해 1을 더한다.
     * 1에 도달할 때까지의 모든 값을 수열에 저장한다.
     */
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();

        while (true) {
            answer.add(n);
            if (n == 1) break;
            n = n % 2 == 0 ? n / 2 : n * 3 + 1;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
