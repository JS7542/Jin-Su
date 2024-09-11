class Solution {
    /*
     * 첫 원소를 알고 있으므로 encoded[i]와 현재 원소를 XOR해 다음 원소를 구한다.
     * 복원된 값을 순서대로 결과 배열에 저장한다.
     */
    public int[] decode(int[] encoded, int first) {
        int[] answer = new int[encoded.length + 1];
        answer[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            answer[i + 1] = answer[i] ^ encoded[i];
        }

        return answer;
    }
}
