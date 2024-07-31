class Solution {
    /*
     * 서로 다른 세 인덱스 i<j<k의 모든 조합을 확인한다.
     * 세 쌍의 절댓값 차이 조건을 모두 만족하는 조합을 센다.
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int answer = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) continue;

                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) answer++;
                }
            }
        }

        return answer;
    }
}
