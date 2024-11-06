class Solution {
    /*
     * k가 양수이면 오른쪽 k개, 음수이면 왼쪽 |k|개 원소를 원형으로 더한다.
     * 각 인덱스에서 필요한 범위를 모듈러 연산으로 순회한다.
     */
    public int[] decrypt(int[] code, int k) {
        int[] answer = new int[code.length];
        if (k == 0) return answer;

        for (int i = 0; i < code.length; i++) {
            int sum = 0;
            int direction = k > 0 ? 1 : -1;

            for (int step = 1; step <= Math.abs(k); step++) {
                int index = (i + direction * step + code.length) % code.length;
                sum += code[index];
            }

            answer[i] = sum;
        }

        return answer;
    }
}
