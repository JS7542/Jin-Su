import java.util.*;

class Solution {
    /*
     * 정수 배열을 오름차순으로 정렬한다.
     * 가장 작은 다섯 개의 값을 복사해 반환한다.
     */
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOf(num_list, 5);
    }
}
