class Solution {
    /*
     * 길이 k인 첫 구간의 흰색 블록 수를 센다.
     * 슬라이딩 윈도우로 구간을 이동하며 흰색 개수의 최솟값을 구한다.
     */
    public int minimumRecolors(String blocks, int k) {
        int white = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') white++;
        }

        int answer = white;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') white++;
            if (blocks.charAt(i - k) == 'W') white--;
            answer = Math.min(answer, white);
        }

        return answer;
    }
}
