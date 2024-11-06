import java.util.*;

class Solution {
    /*
     * 원본 키 배열을 복사해 오름차순으로 정렬한다.
     * 정렬 결과와 원본의 값이 다른 위치 개수를 센다.
     */
    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int answer = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) answer++;
        }
        return answer;
    }
}
