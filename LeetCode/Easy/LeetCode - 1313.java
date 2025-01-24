import java.util.*;

class Solution {
    /*
     * 배열을 빈도와 값의 쌍으로 두 칸씩 읽는다.
     * 각 값을 지정된 빈도만큼 결과 리스트에 반복 추가한다.
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            for (int count = 0; count < nums[i]; count++) {
                answer.add(nums[i + 1]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
