import java.util.*;

class Solution {
    /*
     * 모든 사과의 개수를 합산하고 상자 용량을 오름차순 정렬한다.
     * 큰 용량 상자부터 사용해 모든 사과를 담는 최소 상자 수를 구한다.
     */
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        for (int count : apple) total += count;

        Arrays.sort(capacity);
        int boxes = 0;

        for (int i = capacity.length - 1; total > 0; i--) {
            total -= capacity[i];
            boxes++;
        }

        return boxes;
    }
}
