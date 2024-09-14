class Solution {
    /*
     * 두 배열의 같은 인덱스 원소를 곱한다.
     * 모든 곱의 합을 누적해 내적 결과를 반환한다.
     */
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) answer += a[i] * b[i];
        return answer;
    }
}
