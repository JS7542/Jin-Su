class Solution {
    /*
     * 다른 사람을 믿으면 점수를 1 빼고, 믿음을 받으면 점수를 1 더한다.
     * 점수가 n-1인 사람은 모두에게 믿음을 받고 아무도 믿지 않는 판사다.
     */
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1];

        for (int[] relation : trust) {
            score[relation[0]]--;
            score[relation[1]]++;
        }

        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) return person;
        }

        return -1;
    }
}
