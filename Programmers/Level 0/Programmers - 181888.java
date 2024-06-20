import java.util.*;

class Solution {
    /*
     * 첫 번째 원소부터 n칸 간격으로 배열을 순회한다.
     * 선택된 원소를 기존 순서대로 결과 배열에 담는다.
     */
    public int[] solution(int[] num_list, int n) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < num_list.length; i += n) answer.add(num_list[i]);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
