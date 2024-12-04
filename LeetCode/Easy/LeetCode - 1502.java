import java.util.*;

class Solution {
    /*
     * 배열을 오름차순으로 정렬한다.
     * 모든 인접한 두 수의 차이가 첫 차이와 같은지 확인한다.
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) return false;
        }

        return true;
    }
}
