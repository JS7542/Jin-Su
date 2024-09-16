class Solution {
    /*
     * 새 변이 기존 긴 변보다 짧은 경우와 새 변이 가장 긴 경우를 나누어 범위를 계산한다.
     * 가능한 정수 길이의 총개수는 두 기존 변 중 작은 값의 두 배에서 1을 뺀 값이다.
     */
    public int solution(int[] sides) {
        return Math.min(sides[0], sides[1]) * 2 - 1;
    }
}
