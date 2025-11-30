import java.util.*;

class Solution {
    /*
     * 모든 보석 종류 수를 구하고 슬라이딩 윈도우의 종류별 빈도를 관리한다.
     * 모든 종류가 포함되면 왼쪽을 줄이며 가장 짧은 구간을 갱신한다.
     */
    public int[] solution(String[] gems) {
        int kinds = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> count = new HashMap<>();

        int left = 0;
        int bestLeft = 0;
        int bestRight = gems.length - 1;

        for (int right = 0; right < gems.length; right++) {
            count.put(gems[right], count.getOrDefault(gems[right], 0) + 1);

            while (count.size() == kinds) {
                if (right - left < bestRight - bestLeft) {
                    bestLeft = left;
                    bestRight = right;
                }

                String removed = gems[left++];
                count.put(removed, count.get(removed) - 1);

                if (count.get(removed) == 0) count.remove(removed);
            }
        }

        return new int[]{bestLeft + 1, bestRight + 1};
    }
}
