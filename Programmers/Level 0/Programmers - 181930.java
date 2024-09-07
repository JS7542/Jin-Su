import java.util.*;

class Solution {
    /*
     * 세 주사위 숫자의 서로 다른 값 개수에 따라 계산 단계가 달라진다.
     * 합, 제곱합, 세제곱합을 필요한 횟수만큼 곱해 점수를 구한다.
     */
    public int solution(int a, int b, int c) {
        Set<Integer> distinct = new HashSet<>(Arrays.asList(a, b, c));
        int sum1 = a + b + c;
        int sum2 = a * a + b * b + c * c;
        int sum3 = a * a * a + b * b * b + c * c * c;

        if (distinct.size() == 3) return sum1;
        if (distinct.size() == 2) return sum1 * sum2;
        return sum1 * sum2 * sum3;
    }
}
