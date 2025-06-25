import java.util.*;

class Solution {
    /*
     * N을 i번 사용해 만들 수 있는 수의 집합을 DP로 관리한다.
     * 이어 붙인 수와 두 이전 집합의 사칙연산 결과를 모두 추가한다.
     */
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());

        for (int count = 1; count <= 8; count++) {
            Set<Integer> current = new HashSet<>();
            current.add(Integer.parseInt(String.valueOf(N).repeat(count)));

            for (int leftCount = 1; leftCount < count; leftCount++) {
                int rightCount = count - leftCount;

                for (int left : dp.get(leftCount)) {
                    for (int right : dp.get(rightCount)) {
                        current.add(left + right);
                        current.add(left - right);
                        current.add(left * right);
                        if (right != 0) current.add(left / right);
                    }
                }
            }

            if (current.contains(number)) return count;
            dp.add(current);
        }

        return -1;
    }
}
