class Solution {
    /*
     * L과 R의 이동 차이와 빈칸 개수를 각각 센다.
     * 빈칸을 모두 더 멀어지는 방향으로 사용한 최대 거리를 반환한다.
     */
    public int furthestDistanceFromOrigin(String moves) {
        int position = 0;
        int blank = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'L') position--;
            else if (move == 'R') position++;
            else blank++;
        }

        return Math.abs(position) + blank;
    }
}
