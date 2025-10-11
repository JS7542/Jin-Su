import java.util.*;

class Solution {
    /*
     * 각 기능이 완료되기까지 필요한 날짜를 계산한다.
     * 앞 기능의 배포일보다 늦은 기능을 만나면 새로운 배포 묶음을 시작한다.
     */
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> releases = new ArrayList<>();
        int currentDay = 0;
        int count = 0;

        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

            if (count == 0) {
                currentDay = day;
                count = 1;
            } else if (day <= currentDay) {
                count++;
            } else {
                releases.add(count);
                currentDay = day;
                count = 1;
            }
        }

        releases.add(count);
        return releases.stream().mapToInt(Integer::intValue).toArray();
    }
}
