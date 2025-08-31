import java.util.*;

class Solution {
    /*
     * 각 점수까지 필요한 최소 다트 수와 싱글·불 횟수를 DP로 저장한다.
     * 모든 가능한 한 발 점수를 전이하며 다트 수가 같으면 싱글·불 횟수가 큰 경우를 선택한다.
     */
    public int[] solution(int target) {
        int[] minimumDarts = new int[target + 1];
        int[] singlesAndBulls = new int[target + 1];

        Arrays.fill(minimumDarts, Integer.MAX_VALUE / 4);
        minimumDarts[0] = 0;

        List<int[]> throwsList = new ArrayList<>();

        for (int number = 1; number <= 20; number++) {
            throwsList.add(new int[]{number, 1});
            throwsList.add(new int[]{number * 2, 0});
            throwsList.add(new int[]{number * 3, 0});
        }

        throwsList.add(new int[]{50, 1});

        for (int score = 1; score <= target; score++) {
            for (int[] dart : throwsList) {
                int value = dart[0];

                if (value > score) continue;

                int candidateDarts = minimumDarts[score - value] + 1;
                int candidateSingles = singlesAndBulls[score - value] + dart[1];

                if (candidateDarts < minimumDarts[score]
                        || (candidateDarts == minimumDarts[score]
                        && candidateSingles > singlesAndBulls[score])) {
                    minimumDarts[score] = candidateDarts;
                    singlesAndBulls[score] = candidateSingles;
                }
            }
        }

        return new int[]{minimumDarts[target], singlesAndBulls[target]};
    }
}
