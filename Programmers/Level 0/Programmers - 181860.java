import java.util.*;

class Solution {
    /*
     * flag가 true이면 arr[i]를 arr[i]×2번 결과에 추가한다.
     * false이면 결과의 뒤에서 arr[i]개 원소를 삭제한다.
     */
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int count = 0; count < arr[i] * 2; count++) result.add(arr[i]);
            } else {
                for (int count = 0; count < arr[i]; count++) result.remove(result.size() - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
