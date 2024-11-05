import java.util.*;

class Solution {
    /*
     * 각 정수를 1비트 개수 오름차순으로 정렬한다.
     * 비트 개수가 같으면 정수 값 자체를 오름차순으로 비교한다.
     */
    public int[] sortByBits(int[] arr) {
        Integer[] values = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(values, (a, b) -> {
            int compare = Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
            return compare != 0 ? compare : Integer.compare(a, b);
        });

        return Arrays.stream(values).mapToInt(Integer::intValue).toArray();
    }
}
