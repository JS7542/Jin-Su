import java.util.*;

class Solution {
    /*
     * 짝수 번째 쿼리는 지정 인덱스 뒤를 제거하고 홀수 번째 쿼리는 앞을 제거한다.
     * 현재 배열 기준으로 필요한 구간만 반복해서 잘라낸다.
     */
    public int[] solution(int[] arr, int[] query) {
        int[] current = arr;

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) current = Arrays.copyOfRange(current, 0, query[i] + 1);
            else current = Arrays.copyOfRange(current, query[i], current.length);
        }

        return current;
    }
}
