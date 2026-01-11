import java.util.*;

class Solution {
    /*
     * 중괄호 문자열을 집합별로 분리하고 원소 개수 오름차순으로 정렬한다.
     * 앞 집합에 없던 새 숫자를 순서대로 결과에 추가한다.
     */
    public int[] solution(String s) {
        String content = s.substring(2, s.length() - 2);
        String[] groups = content.split("\\},\\{");

        Arrays.sort(groups, Comparator.comparingInt(group -> group.split(",").length));

        Set<Integer> seen = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for (String group : groups) {
            for (String token : group.split(",")) {
                int value = Integer.parseInt(token);

                if (seen.add(value)) answer.add(value);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
