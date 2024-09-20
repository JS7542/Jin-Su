import java.util.*;

class Solution {
    /*
     * 홀수 길이 배열을 오름차순으로 정렬한다.
     * 가운데 인덱스에 있는 값을 중앙값으로 반환한다.
     */
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
