import java.util.*;

class Solution {
    /*
     * 배열의 최솟값을 찾고 해당 값을 제외한 원소를 새 배열에 저장한다.
     * 원소가 하나뿐이면 문제 조건에 따라 -1 배열을 반환한다.
     */
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(value -> value != min).toArray();
    }
}
