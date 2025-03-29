import java.util.*;

class Solution {
    /*
     * 광물을 다섯 개씩 묶고 각 묶음의 피로도를 계산한다.
     * 캘 수 있는 묶음만 난도가 높은 순으로 정렬해 좋은 곡괭이부터 배정한다.
     */
    public int solution(int[] picks, String[] minerals) {
        int availableGroups = Math.min(
                (minerals.length + 4) / 5,
                picks[0] + picks[1] + picks[2]
        );

        int[][] groups = new int[availableGroups][3];

        for (int group = 0; group < availableGroups; group++) {
            for (int index = group * 5;
                    index < Math.min(minerals.length, group * 5 + 5);
                    index++) {
                int mineral = type(minerals[index]);

                groups[group][0] += 1;
                groups[group][1] += mineral == 0 ? 5 : 1;
                groups[group][2] += mineral == 2 ? 1 : mineral == 1 ? 5 : 25;
            }
        }

        Arrays.sort(groups, (first, second) ->
                Integer.compare(second[2], first[2]));

        int answer = 0;
        int groupIndex = 0;

        for (int pick = 0; pick < 3; pick++) {
            while (picks[pick]-- > 0 && groupIndex < availableGroups) {
                answer += groups[groupIndex++][pick];
            }
        }

        return answer;
    }

    private int type(String mineral) {
        if (mineral.equals("diamond")) return 0;
        if (mineral.equals("iron")) return 1;
        return 2;
    }
}
