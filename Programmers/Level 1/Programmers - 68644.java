import java.util.*;

class Solution {
    /*
     * 서로 다른 두 인덱스의 합을 모두 TreeSet에 저장한다.
     * 중복이 제거되고 정렬된 집합을 정수 배열로 변환한다.
     */
    public int[] solution(int[] numbers) {
        Set<Integer> sums = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sums.add(numbers[i] + numbers[j]);
            }
        }

        return sums.stream().mapToInt(Integer::intValue).toArray();
    }
}
