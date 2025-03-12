import java.util.*;

class Solution {
    /*
     * arr2의 값별 우선순위를 해시맵에 저장한다.
     * arr2에 있는 값은 지정 순서로, 나머지는 오름차순으로 정렬한다.
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> order = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) order.put(arr2[i], i);

        Integer[] values = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(values, (a, b) -> {
            boolean inA = order.containsKey(a);
            boolean inB = order.containsKey(b);

            if (inA && inB) return Integer.compare(order.get(a), order.get(b));
            if (inA) return -1;
            if (inB) return 1;
            return Integer.compare(a, b);
        });

        return Arrays.stream(values).mapToInt(Integer::intValue).toArray();
    }
}
