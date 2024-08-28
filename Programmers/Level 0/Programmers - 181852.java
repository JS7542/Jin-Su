import java.util.*;

class Solution {
    /*
     * 정수 배열을 오름차순으로 정렬한다.
     * 가장 작은 다섯 값을 제외한 나머지 구간을 반환한다.
     */
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 5, num_list.length);
    }
}
