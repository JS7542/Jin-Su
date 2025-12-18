import java.util.*;

class Solution {
    /*
     * 귤 크기별 개수를 센 뒤 빈도 내림차순으로 정렬한다.
     * 많은 크기부터 선택해 K개 이상이 되는 순간 사용한 크기 종류 수를 반환한다.
     */
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int size : tangerine) {
            count.put(size, count.getOrDefault(size, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(count.values());
        frequencies.sort(Collections.reverseOrder());

        int selected = 0;
        int kinds = 0;

        for (int frequency : frequencies) {
            selected += frequency;
            kinds++;

            if (selected >= k) return kinds;
        }

        return kinds;
    }
}
