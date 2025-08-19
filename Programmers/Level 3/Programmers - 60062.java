import java.util.*;

class Solution {
    /*
     * 원형 취약 지점을 두 배 길이 배열로 펼친다.
     * 친구 이동거리의 모든 순열과 시작 취약점을 시도해 필요한 최소 친구 수를 구한다.
     */
    private int answer;
    private int[] weak;
    private int[] dist;
    private boolean[] used;
    private int[] order;
    private int n;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = new int[weak.length * 2];
        this.dist = dist;
        this.used = new boolean[dist.length];
        this.order = new int[dist.length];
        this.answer = dist.length + 1;

        for (int i = 0; i < weak.length; i++) {
            this.weak[i] = weak[i];
            this.weak[i + weak.length] = weak[i] + n;
        }

        permute(0, weak.length);

        return answer > dist.length ? -1 : answer;
    }

    private void permute(int depth, int weakCount) {
        if (depth == dist.length) {
            evaluate(weakCount);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            order[depth] = dist[i];
            permute(depth + 1, weakCount);
            used[i] = false;
        }
    }

    private void evaluate(int weakCount) {
        for (int start = 0; start < weakCount; start++) {
            int friend = 0;
            int coverage = weak[start] + order[friend];

            for (int index = start; index < start + weakCount; index++) {
                if (weak[index] <= coverage) continue;

                friend++;

                if (friend >= order.length) break;

                coverage = weak[index] + order[friend];
            }

            answer = Math.min(answer, friend + 1);
        }
    }
}
