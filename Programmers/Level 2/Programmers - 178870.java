class Solution {
    /*
     * 양수 수열에서 슬라이딩 윈도우 합을 K와 비교한다.
     * 합이 K인 구간 중 길이가 가장 짧고 시작 인덱스가 가장 작은 구간을 저장한다.
     */
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        long sum = 0;
        int bestLeft = 0;
        int bestRight = sequence.length - 1;
        int bestLength = sequence.length + 1;

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k && left <= right) {
                sum -= sequence[left++];
            }

            if (sum == k) {
                int length = right - left + 1;

                if (length < bestLength) {
                    bestLength = length;
                    bestLeft = left;
                    bestRight = right;
                }
            }
        }

        return new int[]{bestLeft, bestRight};
    }
}
