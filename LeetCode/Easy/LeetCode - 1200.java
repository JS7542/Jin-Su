import java.util.*;

class Solution {
    /*
     * 배열을 오름차순으로 정렬하면 최소 차이는 인접한 값 사이에서만 발생한다.
     * 최소 차이를 찾은 뒤 같은 차이를 가진 모든 인접 쌍을 결과에 담는다.
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == min) {
                answer.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return answer;
    }
}
