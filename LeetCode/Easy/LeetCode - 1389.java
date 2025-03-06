import java.util.*;

class Solution {
    /*
     * nums와 index를 같은 순서로 읽으며 리스트의 지정 위치에 값을 삽입한다.
     * 모든 삽입이 끝난 리스트를 정수 배열로 변환한다.
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }

        return target.stream().mapToInt(Integer::intValue).toArray();
    }
}
