class Solution {
    /*
     * 50보다 작은 홀수는 두 배로 만들고 50 이상인 짝수는 절반으로 만든다.
     * 나머지 원소는 그대로 유지한 배열을 반환한다.
     */
    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 50 && arr[i] % 2 == 1) arr[i] *= 2;
            else if (arr[i] >= 50 && arr[i] % 2 == 0) arr[i] /= 2;
        }
        return arr;
    }
}
