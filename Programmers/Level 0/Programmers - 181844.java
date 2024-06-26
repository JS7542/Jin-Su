import java.util.*;

class Solution {
    /*
     * 삭제할 숫자를 해시셋에 저장한다.
     * 원본 배열에서 삭제 목록에 없는 값만 순서를 유지해 반환한다.
     */
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleted = new HashSet<>();
        for (int number : delete_list) deleted.add(number);

        return Arrays.stream(arr)
                .filter(number -> !deleted.contains(number))
                .toArray();
    }
}
