class Solution {
    /*
     * 공은 한 번 던질 때마다 배열에서 두 칸씩 이동한다.
     * K번째로 던지는 사람의 위치를 순환 인덱스로 계산한다.
     */
    public int solution(int[] numbers, int k) {
        return numbers[((k - 1) * 2) % numbers.length];
    }
}
