class Solution {
    /*
     * 상자의 각 변에 주사위 한 변 n이 몇 번 들어가는지 몫을 구한다.
     * 세 방향의 개수를 곱해 넣을 수 있는 주사위 수를 계산한다.
     */
    public int solution(int[] box, int n) {
        return (box[0] / n) * (box[1] / n) * (box[2] / n);
    }
}
