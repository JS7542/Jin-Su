import java.util.*;

class Solution {
    /*
     * 중복 신고를 제거한 뒤 사용자별 신고한 대상 집합을 저장한다.
     * 신고 횟수가 K 이상인 정지 사용자를 신고한 사람의 메일 횟수를 증가시킨다.
     */
    public int[] solution(
            String[] id_list,
            String[] report,
            int k
    ) {
        Map<String, Integer> index = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) index.put(id_list[i], i);

        List<Set<String>> reports = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) reports.add(new HashSet<>());

        int[] reportedCount = new int[id_list.length];

        for (String record : report) {
            String[] parts = record.split(" ");
            int reporter = index.get(parts[0]);
            int target = index.get(parts[1]);

            if (reports.get(reporter).add(parts[1])) {
                reportedCount[target]++;
            }
        }

        int[] answer = new int[id_list.length];

        for (int reporter = 0; reporter < id_list.length; reporter++) {
            for (String targetName : reports.get(reporter)) {
                if (reportedCount[index.get(targetName)] >= k) {
                    answer[reporter]++;
                }
            }
        }

        return answer;
    }
}
