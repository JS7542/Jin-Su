import java.util.*;

class Solution {
    /*
     * 인용 횟수를 오름차순으로 정렬한다.
     * 현재 논문부터 끝까지의 논문 수가 현재 인용 횟수 이하이면 그 수가 최대 H다.
     */
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int papers = citations.length - i;
            if (citations[i] >= papers) return papers;
        }

        return 0;
    }
}
