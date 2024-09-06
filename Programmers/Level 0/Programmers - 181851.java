import java.util.*;

class Solution {
    /*
     * 참가 가능한 학생만 성적 순위 기준으로 정렬한다.
     * 상위 세 학생의 번호를 문제의 계산식에 적용해 반환한다.
     */
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> students = new ArrayList<>();

        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) students.add(i);
        }

        students.sort((a, b) -> Integer.compare(rank[a], rank[b]));
        return 10000 * students.get(0) + 100 * students.get(1) + students.get(2);
    }
}
