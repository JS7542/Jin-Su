class Solution {
    /*
     * 각 단어에 포함된 알파벳을 26비트 마스크로 표현한다.
     * 두 마스크의 AND가 0인 단어 쌍만 길이 곱의 최댓값을 갱신한다.
     */
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];

        for (int index = 0; index < words.length; index++) {
            for (char ch : words[index].toCharArray()) {
                mask[index] |= 1 << (ch - 'a');
            }
        }

        int answer = 0;

        for (int first = 0; first < words.length; first++) {
            for (int second = first + 1; second < words.length; second++) {
                if ((mask[first] & mask[second]) == 0) {
                    answer = Math.max(
                            answer,
                            words[first].length() * words[second].length()
                    );
                }
            }
        }

        return answer;
    }
}
