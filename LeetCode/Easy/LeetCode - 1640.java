import java.util.*;

class Solution {
    /*
     * 각 조각의 첫 값을 키로 사용해 해시맵에 저장한다.
     * arr의 현재 값으로 조각을 찾고 조각 전체가 연속해서 같은지 확인한다.
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) map.put(piece[0], piece);

        int index = 0;
        while (index < arr.length) {
            int[] piece = map.get(arr[index]);
            if (piece == null) return false;

            for (int value : piece) {
                if (index >= arr.length || arr[index++] != value) return false;
            }
        }

        return true;
    }
}
