import java.util.*;

class Solution {
    /*
     * 방문하지 않은 상자에서 시작해 카드 번호를 다음 상자로 따라가며 그룹 크기를 센다.
     * 모든 그룹 크기를 정렬해 가장 큰 두 그룹의 곱을 반환한다.
     */
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groups = new ArrayList<>();

        for (int start = 0; start < cards.length; start++) {
            if (visited[start]) continue;

            int current = start;
            int size = 0;

            while (!visited[current]) {
                visited[current] = true;
                size++;
                current = cards[current] - 1;
            }

            groups.add(size);
        }

        groups.sort(Collections.reverseOrder());

        return groups.size() < 2 ? 0 : groups.get(0) * groups.get(1);
    }
}
