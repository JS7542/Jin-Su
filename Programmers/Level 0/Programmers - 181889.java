import java.util.*;

class Solution {
    /*
     * 배열의 처음부터 n번째 원소까지의 구간을 복사한다.
     * 종료 인덱스가 제외되는 copyOfRange에 n을 전달한다.
     */
    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, 0, n);
    }
}
