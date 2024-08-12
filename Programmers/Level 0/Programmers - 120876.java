class Solution {
    /*
     * 정수 구간의 각 단위 선분이 몇 번 포함되는지 카운팅한다.
     * 두 개 이상의 선분이 덮는 단위 구간의 개수를 합산한다.
     */
    public int solution(int[][] lines) {
        int[] count = new int[201];

        for (int[] line : lines) {
            for (int x = line[0]; x < line[1]; x++) count[x + 100]++;
        }

        int answer = 0;
        for (int value : count) if (value >= 2) answer++;
        return answer;
    }
}
