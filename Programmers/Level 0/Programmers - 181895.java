import java.util.*;

class Solution {
    /*
     * 두 구간의 시작과 끝 인덱스를 순서대로 확인한다.
     * 각 구간 원소를 차례대로 결과 리스트에 추가한다.
     */
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<>();

        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++) answer.add(arr[i]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
