import java.util.*;

class Solution {
    /*
     * 알아볼 수 없는 0의 개수와 당첨 번호가 일치한 개수를 센다.
     * 0이 모두 맞는 경우와 모두 틀리는 경우의 순위를 각각 계산한다.
     */
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winning = new HashSet<>();
        for (int number : win_nums) winning.add(number);

        int zero = 0;
        int matched = 0;

        for (int number : lottos) {
            if (number == 0) zero++;
            else if (winning.contains(number)) matched++;
        }

        return new int[]{rank(matched + zero), rank(matched)};
    }

    private int rank(int count) {
        return count < 2 ? 6 : 7 - count;
    }
}
