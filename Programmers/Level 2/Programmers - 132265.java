import java.util.*;

class Solution {
    /*
     * 오른쪽 토핑 빈도를 미리 세고 왼쪽 집합을 한 칸씩 확장한다.
     * 이동한 토핑은 오른쪽 빈도에서 제거하며 양쪽 토핑 종류 수가 같은 지점을 센다.
     */
    public int solution(int[] topping) {
        Map<Integer, Integer> rightCount = new HashMap<>();

        for (int value : topping) {
            rightCount.put(value, rightCount.getOrDefault(value, 0) + 1);
        }

        Set<Integer> leftKinds = new HashSet<>();
        int answer = 0;

        for (int index = 0; index < topping.length - 1; index++) {
            int value = topping[index];

            leftKinds.add(value);
            rightCount.put(value, rightCount.get(value) - 1);

            if (rightCount.get(value) == 0) rightCount.remove(value);

            if (leftKinds.size() == rightCount.size()) answer++;
        }

        return answer;
    }
}
