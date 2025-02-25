import java.util.*;

class Solution {
    /*
     * 배열을 복사해 정렬하고 서로 다른 값에 작은 순위부터 매핑한다.
     * 원본 배열의 각 값을 매핑된 순위로 바꾸어 반환한다.
     */
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        for (int value : sorted) rank.putIfAbsent(value, rank.size() + 1);

        for (int i = 0; i < arr.length; i++) arr[i] = rank.get(arr[i]);
        return arr;
    }
}
