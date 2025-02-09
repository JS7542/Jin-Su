import java.util.*;

class Solution {
    /*
     * 첫 출발 구간부터 마지막 도착 구간까지 지나간 횟수가 한 번 더 많다.
     * 원형 구간을 고려해 해당 번호를 오름차순으로 결과에 담는다.
     */
    public List<Integer> mostVisited(int n, int[] rounds) {
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        List<Integer> answer = new ArrayList<>();

        if (start <= end) {
            for (int sector = start; sector <= end; sector++) answer.add(sector);
        } else {
            for (int sector = 1; sector <= end; sector++) answer.add(sector);
            for (int sector = start; sector <= n; sector++) answer.add(sector);
        }

        return answer;
    }
}
