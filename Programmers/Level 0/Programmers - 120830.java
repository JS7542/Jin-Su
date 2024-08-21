class Solution {
    /*
     * 양꼬치 열 인분마다 음료 한 개가 무료이므로 유료 음료 수를 계산한다.
     * 양꼬치와 유료 음료의 가격을 더해 총액을 반환한다.
     */
    public int solution(int n, int k) {
        return n * 12000 + (k - n / 10) * 2000;
    }
}
