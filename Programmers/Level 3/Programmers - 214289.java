import java.util.*;

class Solution {
    /*
     * 시간별 실내 온도와 최소 전력 소비를 DP로 관리한다.
     * 에어컨 끄기, 온도 1도 변경, 온도 유지 전이를 적용하고 승객 탑승 시 쾌적 범위만 허용한다.
     */
    public int solution(
            int temperature,
            int t1,
            int t2,
            int a,
            int b,
            int[] onboard
    ) {
        int offset = 10;
        int outside = temperature + offset;
        int comfortableLow = t1 + offset;
        int comfortableHigh = t2 + offset;
        int minimumTemperature = 0;
        int maximumTemperature = 50;
        int infinity = 1_000_000_000;

        int[][] dp = new int[onboard.length][maximumTemperature + 1];

        for (int[] row : dp) Arrays.fill(row, infinity);

        dp[0][outside] = 0;

        for (int time = 1; time < onboard.length; time++) {
            for (int previous = minimumTemperature;
                    previous <= maximumTemperature;
                    previous++) {
                if (dp[time - 1][previous] == infinity) continue;

                int natural = previous;

                if (previous < outside) natural++;
                else if (previous > outside) natural--;

                update(
                        dp,
                        time,
                        natural,
                        dp[time - 1][previous],
                        onboard[time],
                        comfortableLow,
                        comfortableHigh
                );

                update(
                        dp,
                        time,
                        previous,
                        dp[time - 1][previous] + b,
                        onboard[time],
                        comfortableLow,
                        comfortableHigh
                );

                update(
                        dp,
                        time,
                        previous - 1,
                        dp[time - 1][previous] + a,
                        onboard[time],
                        comfortableLow,
                        comfortableHigh
                );

                update(
                        dp,
                        time,
                        previous + 1,
                        dp[time - 1][previous] + a,
                        onboard[time],
                        comfortableLow,
                        comfortableHigh
                );
            }
        }

        int answer = infinity;

        for (int value : dp[onboard.length - 1]) {
            answer = Math.min(answer, value);
        }

        return answer;
    }

    private void update(
            int[][] dp,
            int time,
            int temperature,
            int cost,
            int passenger,
            int comfortableLow,
            int comfortableHigh
    ) {
        if (temperature < 0 || temperature >= dp[time].length) return;

        if (passenger == 1
                && (temperature < comfortableLow
                || temperature > comfortableHigh)) {
            return;
        }

        dp[time][temperature] = Math.min(
                dp[time][temperature],
                cost
        );
    }
}
