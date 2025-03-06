import java.util.*;

class Solution {
    /*
     * 부분 배열을 자유롭게 뒤집을 수 있으므로 두 배열의 원소 빈도만 같으면 된다.
     * 두 배열을 각각 정렬한 뒤 같은지 비교한다.
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
