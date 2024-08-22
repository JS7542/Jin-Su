import java.util.*;

class Solution {
    /*
     * 배열에서 첫 번째 2와 마지막 2의 인덱스를 찾는다.
     * 둘 다 존재하면 해당 구간을 반환하고 없으면 -1 배열을 반환한다.
     */
    public int[] solution(int[] arr) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (first == -1) first = i;
                last = i;
            }
        }

        return first == -1 ? new int[]{-1} : Arrays.copyOfRange(arr, first, last + 1);
    }
}
