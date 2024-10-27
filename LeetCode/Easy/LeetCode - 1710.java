import java.util.*;

class Solution {
    /*
     * 상자당 유닛 수가 큰 종류부터 트럭에 싣도록 정렬한다.
     * 남은 공간만큼 상자를 선택하며 전체 유닛 수를 누적한다.
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int answer = 0;

        for (int[] box : boxTypes) {
            int count = Math.min(truckSize, box[0]);
            answer += count * box[1];
            truckSize -= count;

            if (truckSize == 0) break;
        }

        return answer;
    }
}
