class Solution {
    /*
     * n의 1비트 개수를 저장한다.
     * n보다 큰 수를 하나씩 확인해 같은 1비트 개수를 가진 첫 수를 반환한다.
     */
    public int solution(int n) {
        int bits = Integer.bitCount(n);
        int candidate = n + 1;

        while (Integer.bitCount(candidate) != bits) candidate++;

        return candidate;
    }
}
