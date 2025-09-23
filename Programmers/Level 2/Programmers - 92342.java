class Solution {
    /*
     * 각 점수에서 어피치보다 한 발 더 쏘거나 포기하는 경우를 백트래킹한다.
     * 점수 차이가 최대인 배치를 선택하고 동점이면 낮은 점수를 더 많이 맞힌 배치를 우선한다.
     */
    private int[] apeach;
    private int[] best;
    private int maximumDifference;

    public int[] solution(int n, int[] info) {
        apeach = info;
        search(0, n, new int[11]);

        return best == null ? new int[]{-1} : best;
    }

    private void search(int index, int arrows, int[] ryan) {
        if (index == 11) {
            ryan[10] += arrows;
            evaluate(ryan);
            ryan[10] -= arrows;
            return;
        }

        int needed = apeach[index] + 1;

        if (needed <= arrows) {
            ryan[index] = needed;
            search(index + 1, arrows - needed, ryan);
            ryan[index] = 0;
        }

        search(index + 1, arrows, ryan);
    }

    private void evaluate(int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;

        for (int index = 0; index < 11; index++) {
            if (ryan[index] == 0 && apeach[index] == 0) continue;

            if (ryan[index] > apeach[index]) ryanScore += 10 - index;
            else apeachScore += 10 - index;
        }

        int difference = ryanScore - apeachScore;

        if (difference <= 0) return;

        if (difference > maximumDifference
                || (difference == maximumDifference && better(ryan))) {
            maximumDifference = difference;
            best = ryan.clone();
        }
    }

    private boolean better(int[] candidate) {
        if (best == null) return true;

        for (int index = 10; index >= 0; index--) {
            if (candidate[index] != best[index]) {
                return candidate[index] > best[index];
            }
        }

        return false;
    }
}
