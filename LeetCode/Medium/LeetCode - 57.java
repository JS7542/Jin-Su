import java.util.*;

class Solution {
    /*
     * 새 구간보다 앞에서 끝나는 구간을 먼저 결과에 추가한다.
     * 겹치는 구간은 새 구간과 병합하고 이후 남은 구간을 이어 붙인다.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        int index = 0;

        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            answer.add(intervals[index++]);
        }

        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        answer.add(newInterval);

        while (index < intervals.length) answer.add(intervals[index++]);

        return answer.toArray(new int[0][]);
    }
}
