import java.util.*;

class Solution {
    /*
     * 구간을 시작점 기준으로 정렬한다.
     * 현재 구간과 겹치면 끝점을 확장하고, 겹치지 않으면 새 구간을 시작한다.
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0].clone();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                merged.add(current);
                current = intervals[i].clone();
            }
        }

        merged.add(current);
        return merged.toArray(new int[0][]);
    }
}
