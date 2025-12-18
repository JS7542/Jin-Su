import java.util.*;

class Solution {
    /*
     * 지원자 정보의 네 조건을 실제 값 또는 -로 선택한 16개 키에 점수를 저장한다.
     * 각 점수 목록을 정렬하고 쿼리 기준 점수 이상의 첫 위치를 이분 탐색한다.
     */
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scores = new HashMap<>();

        for (String row : info) {
            String[] parts = row.split(" ");
            makeKeys(parts, 0, new StringBuilder(), scores);
        }

        for (List<Integer> list : scores.values()) Collections.sort(list);

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] parts = query[i].replace(" and ", " ").split(" ");
            String key = String.join(" ", parts[0], parts[1], parts[2], parts[3]);
            int target = Integer.parseInt(parts[4]);

            List<Integer> list = scores.getOrDefault(key, Collections.emptyList());
            int left = 0;
            int right = list.size();

            while (left < right) {
                int mid = (left + right) / 2;

                if (list.get(mid) < target) left = mid + 1;
                else right = mid;
            }

            answer[i] = list.size() - left;
        }

        return answer;
    }

    private void makeKeys(
            String[] parts,
            int index,
            StringBuilder key,
            Map<String, List<Integer>> scores
    ) {
        if (index == 4) {
            String completed = key.substring(0, key.length() - 1);
            scores.computeIfAbsent(completed, value -> new ArrayList<>())
                    .add(Integer.parseInt(parts[4]));
            return;
        }

        int length = key.length();

        key.append(parts[index]).append(' ');
        makeKeys(parts, index + 1, key, scores);
        key.setLength(length);

        key.append("- ");
        makeKeys(parts, index + 1, key, scores);
        key.setLength(length);
    }
}
