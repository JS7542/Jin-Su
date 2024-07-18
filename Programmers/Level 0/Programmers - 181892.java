import java.util.*;

class Solution {
    /*
     * n은 1부터 시작하는 위치이므로 배열 인덱스 n-1부터 시작한다.
     * 해당 위치부터 배열 끝까지 복사해 반환한다.
     */
    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n - 1, num_list.length);
    }
}
