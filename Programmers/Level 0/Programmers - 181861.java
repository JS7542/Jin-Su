import java.util.*;

class Solution {
    /*
     * 배열의 각 값에 대해 그 값과 같은 횟수만큼 결과 리스트에 추가한다.
     * 완성된 리스트를 정수 배열로 변환해 반환한다.
     */
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int number : arr) {
            for (int count = 0; count < number; count++) answer.add(number);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
